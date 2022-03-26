import 'package:frontend/product_genre.dart';

class QuestionScorePair {
  String question = '';
  int score = 0;

  QuestionScorePair(this.question, this.score);
}

class QuestionCalculation {
  Map<ProductGenre, List<QuestionScorePair>> questions = {
    ProductGenre.furniture: [
      QuestionScorePair('新しく買う商品を置くスペースはありますか？', 25),
      QuestionScorePair('今ある商品をまだ使うことはできませんか？', 25),
      QuestionScorePair('衝動買いではありませんか？', 25),
      QuestionScorePair('あなたの現在の生活でその商品は使いますか？', 25),
    ],
    ProductGenre.beauty: [
      QuestionScorePair('衝動買いではありませんか？', 40),
      QuestionScorePair('その商品を買うまでに複数回検討しましたか？', 30),
      QuestionScorePair('同じ商品が残っていませんか？', 30),
    ],
    ProductGenre.foodstuff: [
      QuestionScorePair('その商品をすべて消費することはできますか？', 25),
      QuestionScorePair('その商品にあなたのアレルゲンは含まれていませんか？', 25),
      QuestionScorePair('冷蔵庫や納戸に、その商品を置くためのスペースはありますか？', 25),
      QuestionScorePair('衝動買いではありませんか？', 25),
    ],
    ProductGenre.consumerElectronics: [
      QuestionScorePair('新しく買う商品を置くスペースはありますか？', 25),
      QuestionScorePair('今ある商品をまだ使うことはできませんか？', 25),
      QuestionScorePair('衝動買いではありませんか？', 25),
      QuestionScorePair('あなたの現在の生活でその商品は使いますか？', 25),
    ],
    ProductGenre.mourning: [
      QuestionScorePair('今ある商品をまだ使うことはできませんか？', 20),
      QuestionScorePair('その商品は複数回、長期的に着用し続けますか？', 20),
      QuestionScorePair('その商品は今のあなたにとって本当に必要ですか？', 30),
      QuestionScorePair('その商品を処分するとき、どのように処分するか考えていますか？', 15),
      QuestionScorePair('衝動買いではありませんか？', 15),
    ],
    ProductGenre.other: [
      QuestionScorePair('新しく買う商品を置くスペースはありますか？', 20),
      QuestionScorePair('今ある商品をまだ使うことはできませんか？', 20),
      QuestionScorePair('衝動買いではありませんか？', 20),
      QuestionScorePair('あなたの現在の生活でその商品は使いますか？', 20),
      QuestionScorePair('すでに似たようなものを持っていませんか？', 20),
    ],
  };

  // 購入可否判定
  String ableToByOne(int score) {
    if(score >= 80) {
      return 'その買い物、じっくり考えられています！';
    } else if(score >= 50) {
      return 'その買い物、一度考え直してみませんか？';
    }
    return 'その買い物、じっくり考え直してみませんか？';
  }

  // 文字列からenumへの変換
  ProductGenre stringToProductGenre(String string) {
    if(string == '家具・インテリア') {
      return ProductGenre.furniture;
    } if(string == '服') {
      return ProductGenre.mourning;
    } if(string == '家電') {
      return ProductGenre.consumerElectronics;
    } if(string == '美容・コスメ') {
      return ProductGenre.beauty;
    } if(string == '食品') {
      return ProductGenre.foodstuff;
    }
    return ProductGenre.other;
  }
}
