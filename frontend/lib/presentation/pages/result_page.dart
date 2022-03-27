import 'package:flutter/material.dart';
import 'package:frontend/presentation/pages/judge_page.dart';

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
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text(widget.score.toString()),
    );
  }
}
