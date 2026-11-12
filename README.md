# PvP Crosshair

A lightweight and customizable PvP crosshair mod for Fabric that enhances combat without changing vanilla gameplay.

Designed to be clean, fast, and fully configurable.

## Features

- 🎯 Multiple crosshair styles
  - Corner (Default)
  - Star
  - Chevron
  - Vanilla

- 🟢 Smart target detection
  - Crosshair changes color when aiming at a living entity.

- 🛡 Shield detection
  - Detects when the target is actively blocking with a shield.

- 🎨 Fully customizable
  - Crosshair style
  - Crosshair size
  - Idle opacity
  - Target opacity
  - Shield opacity
  - Idle, Target and Shield colors (ARGB)

- ⚙ In-game configuration
  - Mod Menu support
  - Cloth Config integration

- 💾 Automatic configuration saving

- 🎮 Preserves vanilla behavior
  - Vanilla attack indicator
  - Vanilla spectator crosshair behavior

## Requirements

- Minecraft 1.21.11, 26.1.x, 26.2 or 26.3
- Fabric Loader
- Fabric API

### Optional

- Mod Menu
- Cloth Config

Both are needed only for the in-game configuration screen. Without them the mod still works and reads its settings from `config/pvpcrosshair.json`.

## Installation

1. Install Fabric Loader.
2. Install Fabric API.
3. Download the jar that matches your Minecraft version, e.g. `pvpcrosshair-1.0.0+mc26.3.jar`.
4. Place it into your `mods` folder.
5. (Optional) Install Mod Menu and Cloth Config for the in-game configuration screen.

## Compatibility

| Minecraft | Jar |
|---|---|
| 1.21.11 | `pvpcrosshair-<version>+mc1.21.11.jar` |
| 26.1, 26.1.1, 26.1.2 | `pvpcrosshair-<version>+mc26.1.jar` |
| 26.2 | `pvpcrosshair-<version>+mc26.2.jar` |
| 26.3 | `pvpcrosshair-<version>+mc26.3.jar` |

## Building

All Minecraft versions are built from this one project:

```
./gradlew build
```

The jars end up in `build/libs/`. To build a single version use `./gradlew :26.3:build`, and to start a test client `./gradlew :26.3:runClient`.

Project layout:

- `src/` - code shared by every Minecraft version
- `versions/<mc>/src/` - the few classes that differ per Minecraft version (HUD hook and mixin)
- `versions/<mc>/gradle.properties` - Minecraft and dependency versions for that build

Building needs JDK 25.

## License

This project is licensed under the MIT License.

## Author

**CoresCode**