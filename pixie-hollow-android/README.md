# Pixie Hollow Android

This project builds a dedicated Android launcher for Flash-based Pixie Hollow clients by applying a small overlay to the official open-source Ruffle Android player.

## What it does

- Builds a native ARM64 Android APK using Ruffle.
- Uses a separate application ID: `com.brandonvalley.pixiehollowandroid`.
- Renames the app to `Pixie Hollow Android`.
- Prefills the public PixieHollowRE `container.swf` URL.
- Lets the user replace the SWF URL from the launcher screen when the live client URL changes.
- Forces the player into sensor-aware landscape mode.
- Enables native Ruffle socket support.
- Fixes Ruffle Android's content base URL so relative Pixie Hollow XML, SWF, image, and other asset requests resolve relative to the actual client URL.
- Supplies the Flash variables used by the original Pixie Hollow `live.html` launcher:
  - `session=xml/sessions/mmo.xml`
  - `currentUrl=<content root>/live.html`
  - `htmlEnvironment=`
  - `base=<content root>/`

## Build output

The GitHub Actions workflow is located at:

`.github/workflows/pixie-hollow-android.yml`

A successful workflow run uploads this artifact:

`PixieHollowAndroid-arm64-v8a.apk`

The APK targets modern 64-bit ARM Android phones, including current Samsung Galaxy devices.

## Important limitation

The default URL points to the public PixieHollowRE GitHub archive. That is useful for testing whether the client renders and loads its static dependencies, but GitHub is not the live Pixie Hollow game server. Login and multiplayer require the current live client URL and active backend services.

Paste the live team's direct `container.swf` URL into the launcher when it is available. The app derives the content root from a URL ending in `/swf/container.swf`.

## Source and assets

This repository does not bundle Disney or Pixie Hollow game assets. The APK loads a user-selected remote SWF URL at runtime.

Ruffle Android and Ruffle are third-party open-source projects. Their upstream licenses and notices remain in the checked-out source used during the build. This overlay is not affiliated with Disney, Ruffle, or the Pixie Hollow Rewritten team.

## Updating Ruffle Android

The workflow pins a known Ruffle Android commit so the source patch remains reproducible. To update it, change `RUFFLE_ANDROID_COMMIT` in the workflow and run the build. If upstream code changed around one of the patched sections, `apply_overlay.py` stops with a clear error instead of silently producing a broken APK.
