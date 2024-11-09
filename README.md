# Up-to-date Native Android Boilerplate Code


## 🚀 Quick Start

1. Import into Android Studio, click run, and just get started building a scalable maintainable app (update to the [latest Android Studio version](https://developer.android.com/studio)).
2. Rename everything prefixed with *Rename* ([How to rename a package in Android Studio](https://stackoverflow.com/questions/16804093/rename-package-in-android-studio))

```bash
git clone https://github.com/pim-developer/modern-android-template-quick-start.git
```

## 👨‍💼 Architecture 

Based on the [Official Android Documentation](https://developer.android.com/topic/architecture):

- **Activity Structure:** Single Activity Architecture
- **Design Pattern:** MVVM (Model-View-ViewModel)
- **Modularization:** 1 Module

## 📂 Folder Structure

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

## ⚒️ Included Dependencies 

- [**MongoDB**](https://www.mongodb.com/docs/atlas/device-sdks/sdk/kotlin/) - NoSQL Database MongoDB, note there is a nice free tier for a MongoDB [BAAS](https://www.mongodb.com/products/platform/atlas-database). Easily replace with [Room](https://developer.android.com/jetpack/androidx/releases/room) if you prefer.
- [**Hilt**](https://developer.android.com/training/dependency-injection/hilt-android) -  Hilt Dependency Injection for a future-proof maintainable codebase.
- **[Compose Navigation](https://developer.android.com/develop/ui/compose/navigation)** - Up-to-date Official Jetpack Compose Type-Safe Navigation.
- **Ktor Android** - For networking.
- **Jetpack Compose** - The Official Android Declarative UI-Kit.
- **Material 3** - The latest version of Material Design.
- **Firebase Crashlytics** _(Planned)_ - For crash reporting.
- **In-App Updates** - code in ui/utils/AppUpdater.kt 
- **KtLint** - For code quality.

## 🤝 Contribute to this Project 

Don't hesitate!

## License 

This project is licensed under the [MIT License](https://github.com/pim-developer/modern-android-template-quick-start?tab=MIT-1-ov-file). Feel free to use it for your projects.
