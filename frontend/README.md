# frontend

## 環境

- flutter 2.10.0-stable

## 導入

- asdf の場合

```sh

cd frontend

asdf install
flutter run

# done!
```

## 状態管理

Riverpod + stateNotifier + freezed を採用

## アーキテクチャ

今回はドメイン駆動設計を採用しています。
ただし、より高スムーズに開発ができるように少し改良を加えています。

```
common/
│   └── color.dart (collect color constant)
│   └── theme.dart (collect theme code)
├── helper
│   └── ~.dart
├── constants
│   └── ~.dart
domain/
├── models (define immutable domain model.)
│   └── ~.dart
├── repository (can get outside information, such as database, etc...)
│   └── ~_repository.dart
├── useCase (realize use case, only describe the process)
│   └── ~_useCase.dart
notifier/
├── state (state of stateNotifier)
│   └── ~state.dart
├── notifier (logic part of stateNotifier)
│   └── ~notifier.dart
pages/
├── ~
│   └── index.dart
└── app.dart
└── main.dart
```
