# Дипломный проект по профессии «Инженер по тестированию»

## Тестирование мобильного приложения «Мобильный хоспис»

[Ссылка на задание](https://github.com/netology-code/qamid-diplom)

## Документация
-[План тестирования]()
-[Чек-лист]()
-[Тест-кейсы]()
-[Отчет о тестировании]()


# Запуск приложения и тестов 
## Окружение:
* Java: 
  * Openjdk 11.0.18 2023-01-17
  * OpenJDK Runtime Environment Temurin-11.0.18+10 (build 11.0.18+10)
  * OpenJDK 64-Bit Server VM Temurin-11.0.18+10 (build 11.0.18+10, mixed mode)
* Android Studio Koala Feature Drop | 2024.1.2 Patch 1, эмулятор Pixel 5 API 29
* Allure 2.35.1


## Запуск автотестов:
Убедитесь, что у вас установлены JDK и Android Studio.
В Android Studio, перейдите в Tools > SDK Manager.
Создайте эмулятор Pixel 5 с API 29 через AVD Manager.
На локальном компьютере откройте терминал.
Склонируйте репозиторий командой git clone
Откройте проект в Android Studio.
Запустите приложение app на эмуляторе Pixel 5 API 29.
Запустите тесты из командной строки./gradlew connectedAndroidTest.
