#!/usr/bin/env python3

from __future__ import annotations

import re
import sys
from pathlib import Path


def replace_once(text: str, old: str, new: str, description: str) -> str:
    count = text.count(old)
    if count != 1:
        raise RuntimeError(
            f"Expected exactly one match for {description}, found {count}. "
            "The pinned Ruffle Android source may have changed."
        )
    return text.replace(old, new, 1)


def write_text(path: Path, content: str) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content, encoding="utf-8")


def patch_select_screen(root: Path) -> None:
    path = root / "app/src/main/java/rs/ruffle/SelectSwfScreen.kt"
    text = path.read_text(encoding="utf-8")

    brand_pattern = re.compile(
        r"@Composable\nfun BrandBar\(\) \{.*?\n\}",
        flags=re.DOTALL,
    )
    brand_replacement = """@Composable
fun BrandBar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 48.dp)
    ) {
        Text(
            text = \"Pixie Hollow\",
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center
        )
        Text(
            text = \"Android Launcher\",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )
        Text(
            text = \"Powered by Ruffle\",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(
                alpha = SLIGHTLY_DEEMPHASIZED_ALPHA
            ),
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}"""
    text, count = brand_pattern.subn(brand_replacement, text, count=1)
    if count != 1:
        raise RuntimeError("Could not replace the Ruffle brand bar")

    text = replace_once(
        text,
        "mutableStateOf(UrlState())",
        "mutableStateOf(UrlState(DEFAULT_PIXIE_SWF_URL))",
        "default SWF URL state",
    )

    marker = "import rs.ruffle.ui.theme.SLIGHTLY_DEEMPHASIZED_ALPHA\n"
    constant = (
        marker
        + "\nprivate const val DEFAULT_PIXIE_SWF_URL =\n"
        + "    \"https://raw.githubusercontent.com/PixieHollowRE/web/main/swf/container.swf\"\n"
    )
    text = replace_once(text, marker, constant, "Pixie Hollow URL constant")
    path.write_text(text, encoding="utf-8")


def patch_strings(root: Path) -> None:
    path = root / "app/src/main/res/values/strings.xml"
    write_text(
        path,
        """<resources>
    <string name=\"app_name\">Pixie Hollow Android</string>
    <string name=\"logo_description\">Pixie Hollow Android</string>
    <string name=\"or\">Advanced</string>
    <string name=\"open_url\">Fly to Pixie Hollow</string>
    <string name=\"select_a_swf\">Choose a different SWF</string>
    <string name=\"url\">Pixie Hollow SWF URL</string>
    <string name=\"work_in_progress_warning\">Experimental Android launcher using Ruffle. The public Pixie Hollow archive is prefilled. If the live team changes the client URL, paste the new SWF URL below.</string>
</resources>
""",
    )


def patch_manifest(root: Path) -> None:
    path = root / "app/src/main/AndroidManifest.xml"
    text = path.read_text(encoding="utf-8")
    text = replace_once(
        text,
        'android:screenOrientation="user"',
        'android:screenOrientation="sensorLandscape"',
        "player orientation",
    )
    path.write_text(text, encoding="utf-8")


def patch_gradle(root: Path) -> None:
    path = root / "app/build.gradle.kts"
    text = path.read_text(encoding="utf-8")
    text = replace_once(
        text,
        'applicationId = "rs.ruffle"',
        'applicationId = "com.brandonvalley.pixiehollowandroid"',
        "application ID",
    )
    text = replace_once(text, "versionCode = 260717", "versionCode = 1", "version code")
    text = replace_once(
        text,
        'versionName = "0.260717"',
        'versionName = "0.1.0"',
        "version name",
    )
    path.write_text(text, encoding="utf-8")


def patch_rust_player(root: Path) -> None:
    path = root / "src/lib.rs"
    text = path.read_text(encoding="utf-8")

    duplicated_jni_block = """                                let (jvm, activity) = get_jvm().unwrap();
                                let mut env = jvm.attach_current_thread().unwrap();
                                let url = JavaInterface::get_swf_uri(&mut env, &activity);
                                let bytes = JavaInterface::get_swf_bytes(&mut env, &activity);

"""
    text = replace_once(
        text,
        duplicated_jni_block,
        "",
        "original late SWF URI lookup",
    )

    original_movie_url = """                                let movie_url = Url::parse("file://movie.swf").unwrap();
                                let player_id = PlayerId::new();
"""
    pixie_movie_url = """                                let (jvm, activity) = get_jvm().unwrap();
                                let mut env = jvm.attach_current_thread().unwrap();
                                let url = JavaInterface::get_swf_uri(&mut env, &activity);
                                let bytes = JavaInterface::get_swf_bytes(&mut env, &activity);
                                let root_movie_url = Url::parse(&url)
                                    .unwrap_or_else(|_| Url::parse("file://movie.swf").unwrap());
                                let content_base_url = root_movie_url
                                    .join("../")
                                    .unwrap_or_else(|_| root_movie_url.clone());
                                let current_url = content_base_url
                                    .join("live.html")
                                    .unwrap_or_else(|_| content_base_url.clone());
                                let parameters = vec![
                                    ("session".to_string(), "xml/sessions/mmo.xml".to_string()),
                                    ("currentUrl".to_string(), current_url.to_string()),
                                    ("htmlEnvironment".to_string(), String::new()),
                                    ("base".to_string(), content_base_url.to_string()),
                                ];
                                let player_id = PlayerId::new();
"""
    text = replace_once(
        text,
        original_movie_url,
        pixie_movie_url,
        "real movie and content base URLs",
    )

    text = replace_once(
        text,
        "                                    movie_url.clone(),",
        "                                    content_base_url.clone(),",
        "navigator base URL",
    )
    text = replace_once(
        text,
        "Rc::new(PlayingContent::DirectFile(ContentDescriptor::new_remote(movie_url))),",
        "Rc::new(PlayingContent::DirectFile(ContentDescriptor::new_remote(root_movie_url.clone()))),",
        "playing content URL",
    )
    text = replace_once(
        text,
        "player_lock.fetch_root_movie(url, Vec::new(), Box::new(|_| {}))",
        "player_lock.fetch_root_movie(url, parameters, Box::new(|_| {}))",
        "Pixie Hollow FlashVars",
    )
    path.write_text(text, encoding="utf-8")


def main() -> None:
    if len(sys.argv) != 2:
        raise SystemExit("Usage: apply_overlay.py PATH_TO_RUFFLE_ANDROID")

    root = Path(sys.argv[1]).resolve()
    required = [
        root / "app/build.gradle.kts",
        root / "src/lib.rs",
        root / "app/src/main/AndroidManifest.xml",
    ]
    missing = [str(path) for path in required if not path.exists()]
    if missing:
        raise FileNotFoundError("Missing Ruffle Android files: " + ", ".join(missing))

    patch_select_screen(root)
    patch_strings(root)
    patch_manifest(root)
    patch_gradle(root)
    patch_rust_player(root)
    print(f"Applied Pixie Hollow Android overlay to {root}")


if __name__ == "__main__":
    main()
