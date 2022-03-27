import 'package:flutter/material.dart';
import 'package:frontend/domain/useCase/question_calculation.dart';
import 'package:frontend/presentation/pages/judge_page.dart';
import 'package:frontend/presentation/pages/result_page.dart';

class QuestionPage extends StatelessWidget {
  String productGenre = '';
  QuestionPage(this.productGenre, {Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: QuestionPageWidget(productGenre),
      ),
    );
  }
}

/// This is the stateful widget that the main application instantiates.
class QuestionPageWidget extends StatefulWidget {
  final String param; //上位Widgetから受け取りたいデータ
  const QuestionPageWidget(this.param, {Key? key}) : super(key: key);

  @override
  State<QuestionPageWidget> createState() => _QuestionPageWidgetState(0, 0);
}

/// This is the private State class that goes with QuestionPageWidget.
class _QuestionPageWidgetState extends State<QuestionPageWidget> {
  int allScore = 0;
  int questionIndex = 0;
  _QuestionPageWidgetState(this.questionIndex, this.allScore);
  QuestionCalculation questionCalculation = QuestionCalculation();

  List<QuestionScorePair> getQuestionScorePairs() {
    List<QuestionScorePair>? tmp = questionCalculation
        .questions[questionCalculation.stringToProductGenre(widget.param)];
    if (tmp != null) {
      return tmp;
    }
    return [];
  }

  @override
  Widget build(BuildContext context) {
    List<QuestionScorePair> questionScorePairs = getQuestionScorePairs();
    String question = questionScorePairs[questionIndex].question;
    int score = questionScorePairs[questionIndex].score;

    return Center(
      child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(question),
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              ElevatedButton(
                  onPressed: () {
                    allScore += score;
                    if (questionScorePairs.length - 1 == questionIndex) {
                      Navigator.of(context)
                          .pushReplacement(MaterialPageRoute(builder: (context) {
                        return ResultPage(allScore);
                      }));
                    } else {
                      questionIndex += 1;
                      setState(() {});
                    }
                  },
                  child: const Text('はい')),
              ElevatedButton(
                  onPressed: () {
                    allScore += score ~/ 2;
                    if (questionScorePairs.length - 1 == questionIndex) {
                      Navigator.of(context)
                          .pushReplacement(MaterialPageRoute(builder: (context) {
                        return ResultPage(allScore);
                      }));
                    } else {
                      questionIndex += 1;
                      setState(() {});
                    }
                  },
                  child: const Text('微妙かも..')),
              ElevatedButton(
                  onPressed: () {
                    if (questionScorePairs.length - 1 == questionIndex) {
                      Navigator.of(context)
                          .pushReplacement(MaterialPageRoute(builder: (context) {
                        return ResultPage(allScore);
                      }));
                    } else {
                      questionIndex += 1;
                      setState(() {});
                    }
                  },
                  child: const Text('いいえ')),
            ],
          )
        ],
      ),
    );
  }
}
