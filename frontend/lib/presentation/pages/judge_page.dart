import 'package:flutter/material.dart';
import 'package:frontend/ProductGenre.dart';
import 'package:frontend/presentation/pages/question_page.dart';

class JudgePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: JudgePageWidget(),
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
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          Text('購入する商品のジャンルを選択'),
          DropdownButton<String>(
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
          ),
          RaisedButton(
            child: Text('次へ'),
            onPressed: () {
              Navigator.push(
                context,
                MaterialPageRoute(builder: (context) => QuestionPage(this.dropdownValue)),
              );
            },
          ),
        ],
      ),
    );
  }
}
