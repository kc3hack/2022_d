import 'package:flutter/material.dart';
import 'package:frontend/ProductGenre.dart';

class JudgePage extends StatelessWidget {
  const JudgePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: const Center(
        child: JudgePageWidget(),
      ),
    );
  }
}

/// This is the stateful widget that the main application instantiates.
class JudgePageWidget extends StatefulWidget {
  const JudgePageWidget({Key? key}) : super(key: key);

  @override
  State<JudgePageWidget> createState() => _JudgePageWidgetState();
}


/// This is the private State class that goes with JudgePageWidget.
class _JudgePageWidgetState extends State<JudgePageWidget> {
  String dropdownValue = '家具・インテリア';

  @override
  Widget build(BuildContext context) {
    return DropdownButton<String>(
      value: dropdownValue,
      icon: const Icon(Icons.arrow_downward),
      iconSize: 24,
      elevation: 24,
      style: const TextStyle(color: Colors.deepPurple),
      underline: Container(
        height: 2,
        color: Colors.deepPurpleAccent,
      ),
      onChanged: (String? newValue) {
        setState(() {
          dropdownValue = newValue!;
        });
      },
      items: <String>['家具・インテリア', '服', '家電', '美容・コスメ', '食品', 'その他']
          .map<DropdownMenuItem<String>>((String value) {
        return DropdownMenuItem<String>(
          value: value,
          child: Text(value),
        );
      }).toList(),
    );
  }
}

