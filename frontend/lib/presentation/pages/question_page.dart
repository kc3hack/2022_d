import 'package:flutter/material.dart';
import 'package:frontend/presentation/pages/judge_page.dart';

class QuestionPage extends StatelessWidget {
  String product_genre;
  QuestionPage(this.product_genre);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
            child: Text(this.product_genre),
      ),
    );
  }
}
