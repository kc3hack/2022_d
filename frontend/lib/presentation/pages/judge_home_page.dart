import 'package:flutter/material.dart';
import 'package:frontend/presentation/pages/judge_page.dart';

class JudgeHomePage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: JudgeHomePageWidget(),
    );
  }
}

/// This is the stateful widget that the main application instantiates.
class JudgeHomePageWidget extends StatefulWidget {
  const JudgeHomePageWidget({Key? key}) : super(key: key);

  @override
  State<JudgeHomePageWidget> createState() => _JudgeHomePageWidgetState();
}

/// This is the private State class that goes with JudgeHomePageWidget.
class _JudgeHomePageWidgetState extends State<JudgeHomePageWidget> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: ElevatedButton(
        child: const Text('診断を開始する'),
        onPressed: () {
          Navigator.pushReplacement(
            context,
            MaterialPageRoute(builder: (context) => JudgePage()),
          );
        }
      )
    );
  }
}
