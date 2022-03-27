import 'package:flutter/material.dart';
import 'package:frontend/domain/useCase/question_calculation.dart';
import 'package:frontend/presentation/pages/judge_home_page.dart';

class ResultPage extends StatelessWidget {
  int score = 0;
  ResultPage(this.score, {Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        body: Center(
      child: ResultPageWidget(score),
    ));
  }
}

/// This is the stateful widget that the main application instantiates.
class ResultPageWidget extends StatefulWidget {
  final int score;
  const ResultPageWidget(this.score, {Key? key}) : super(key: key);

  @override
  State<ResultPageWidget> createState() => _ResultPageWidgetState();
}

/// This is the private State class that goes with ResultPageWidget.
class _ResultPageWidgetState extends State<ResultPageWidget> {
  QuestionCalculation questionCalculation = QuestionCalculation();
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            widget.score.toString(),
            style: const TextStyle(
              fontSize: 96,
            ),
          ),
          Text(
            questionCalculation.ableToByOne(widget.score),
            style: const TextStyle(
              fontSize: 16,
            ),
          ),
          ElevatedButton(
              onPressed: () {
                Navigator.of(context)
                    .pushReplacement(MaterialPageRoute(builder: (context){
                  return JudgeHomePage();
                }));
              },
              child: const Text('ホームに戻る'),
          )
        ],
      ),
    );
  }
}
