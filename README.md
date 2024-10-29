# Modern Android Template Quick Start

*Welcome!* This is a ready-to-use template for starting a fresh Android app with all the latest goodies to help you quickly get started on a scalable and maintainable app 🚀‍.

*I will try to always keep it up to date (please feel free to contribute)*

## Quick Start

Clone this repository into Android Studio, and click run (here's a friendly reminder to update to the [latest Android Studio version](https://developer.android.com/studio)).

```bash
git clone https://github.com/pim-developer/modern-android-template-quick-start.git
```

**Tip:** I prefixed everything that needs renaming with *Rename*, if you're not familiar with renaming packages or if it becomes a hassle, here's a guide: [How to rename a package in Android Studio](https://stackoverflow.com/questions/16804093/rename-package-in-android-studio).


## Table of Contents

- [Quick Start](#quick-start)
- [Architecture](#architecture)
- [Folder Structure](#folder-structure)
- [Included Dependencies](#included-dependencies)
- [Version Catalog](#version-catalog)
- [Contributing](#contributing)
- [License](#license)

## Architecture

This template follows the official Google best practises [guide](https://developer.android.com/topic/architecture):

- **Activity Structure:** Single Activity Architecture
- **Design Pattern:** MVVM (Model-View-ViewModel)
- **Modularization:** 1 Module

## Folder Structure

The project structure is organized as follows (seperation of concerns):

- `app/`
    - `src/`
        - `main/`
            - `java/com/renamecompanyname/renameappname`
                - `ui/` - Contains all UI-related stuff; Screens, [Compose Navigation](https://developer.android.com/develop/ui/compose/navigation)
                - `presentation/` - ViewModels for handling UI data
                - `model/` - Data models
                - `data/` - Data management classes
                - `di/` - Dependency Injection class modules
            - `res/` - Resources like layouts, drawables, and strings
        - `test/` - Unit testing files
        - `androidTest/` - Android specific Instrumentation testing files

## Included Dependencies

- [**MongoDB**](https://www.mongodb.com/docs/atlas/device-sdks/sdk/kotlin/) - NoSQL Database MongoDB, note there is a nice free tier for a MongoDB [BAAS](https://www.mongodb.com/products/platform/atlas-database). Easily replace with [Room](https://developer.android.com/jetpack/androidx/releases/room) if you prefer.
- [**Hilt**](https://developer.android.com/training/dependency-injection/hilt-android) -  Hilt Dependency Injection for a future-proof maintainable codebase.
- **[Compose Navigation](https://developer.android.com/develop/ui/compose/navigation)** - Up-to-date Official Jetpack Compose Type-Safe Navigation.
- **Jetpack Compose** - The Official Android Declarative UI-Kit.
- **Material 3** - The latest version of Material Design.
- **Firebase Crashlytics** _(Planned)_ - For crash reporting.
- **In-App Updates** - code in ui/utils/AppUpdater.kt 
- **KtLint** - For code quality.


### Version Catalog

The project uses a version catalog file, `libs.versions.toml`, to manage all dependencies across the project. This file is a `.toml` format that helps manage dependencies and versions in a scalable, organized, and modern way. Learn more here: [Migrate to Version Catalogs](https://developer.android.com/build/migrate-to-catalogs).

## Contributing

Please feel free to contribute! There are TODO's (see Issues Tab)

## License

This project is licensed under the [MIT License](https://github.com/pim-developer/modern-android-template-quick-start?tab=MIT-1-ov-file). Feel free to use it for your projects.
