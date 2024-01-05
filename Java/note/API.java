パッケージ宣言
//どのフォルダに保存されてるかを示す。
//ルートディレクトリ...最上位のディレクトリ
package ディレクトリ名;
//複数の階層に分かれる場合は次のように上位の階層からドットで繋ぐ
package ディレクトリ1、ディレクトリ2、ディレクトリ3;
//サブパッケージ...入れ子になっているフォルダのパッケージ

パッケージされたクラスを利用する
パッケージ名.クラス名//完全限定名

ターミナルでパッケージされたクラスの実行する
javac ディレクトリ1/javaファイル名//コンパイル
java パッケージ名.クラス名

インポート
//　パッケージされたクラスを事前に取得する
import パッケージ名.クラス名;
//(下)同一パッケージの複数のクラスをまとめてインポートする
import パッケージ名.クラス名.*;
//パッケージは別でも、クラス名が同じ場合importは利用不可。都度、完全限定名で指定する必要がある。

標準API//java機能として標準的に備わったクラス集のようなもの
//参考リンクhttps://docs.oracle.com/javase/jp/8/docs/api/

標準APIの読み込み
import java.パッケージ名.クラス名;

標準APIの利用
クラス名 変数名 = new クラス名();
//インスタンス生成をする

java.langパッケージ
//基本データ型の操作をはじめ、数値計算や入出力などJava言語による開発における最も基本的なクラスが用意されている。
//importの実行不要。

ラッパークラス//基本データ型のクラス
//boolean(Boolean),byte(Byte),char(Character),shot(Short),int(Integer),float(Float),long(Long),double(Double)がある。
//()は対応するラッパークラス。

Integerクラス
型 変換後の変数名 = Integer.parseInt(変換前の変数名);//変換前の変数がInt型に置換される。
//例外:NumberFormatException
型 変換後の変数名 = Integer.toString(変換前の変数名);//変換前の変数がString型に置換される。
メソッド名(Integer.compare(値x, 値y));//x,yを比較してint型の値(0 または1 または-1)を返す。
//x == y : 0
//x > y : 1
//x < y : -1
//基本データ型とラッパークラスが対になる場合、自動的に型変換される。
//parseInt(),toString(),compare()は他のラッパークラスでも用意されている。

Mathクラス
型 変数名 = Math.pow(値1の変数名, 値2の変数名);//値1の変数を値2乗した変数を返す。
Math .ceil(値);//値を切り上げて返す。
Math .floor(値);//値を切り捨てて返す。
Math.max(値, 値);//第一引数と第二引数の大きい方を返す。両方の型は揃える。

Stringクラス
変数名.length();//文字の長さを取得する。
char 変数名 = 文字列の変数名.charAt(値);//文字列の値番めの文字を返す。配列同様0から順に割り振られる。
変数名.indexOf("文字");//文字列内にsearchValueの順番を値で返す。
//第二引数に値を指定した場合は、値番以降をサーチする。
//無い場合は-1を返す。
変数名.substring(値);//文字列を指定した位置から最後まで部分的な文字列を返す。
//第二引数を指定した場合は、その範囲で文字列を返す。
//endIndexを指定すると、最後ではなく、指定したインデックス-1までの文字を返す。
変数名.isEmpty()//文字列の長さが0かどうかをboolean型で返す。0ならばfalse。
変数名.equals("文字列");//変数内の文字列と指定した文字列が同じ値だった時にtrue、そうでなければfalse。
//nullを指定した場合nullならtrue。
変数名 = 変数名.contact("文字");//指定した文字列に文字を連結して返す。
//ドットで複数連結できる。
型 変数名 = String.join(第一引数, 第二引数...)
//第二引数は配列もしくは複数の引数からなる。
//...がつくものを可変長引数という。
//第二引数以降を第一引数区切りで結合する。
変数名.split("文字");//文字で区切られた文字列を配列として返す。
変数名[0];
変数名[1];
変数名[2];...

java.utilパッケージ
//import必要
Randomクラス
Random random = new Random();//インスタンス生成
型 変数名 = random.nextInt()//-2147483648~2147483647までのint値をランダムで取得。
//引数に5を指定した場合、0~4の値をランダムで返す。
double 変数名 = random.nextDouble();//0.0~1.0までのランダムな値を返す。
Arraysクラス//配列の並べ替えや文字列としての表現への変換などを行うことが可能。
Arrays.toString(変数名);//引数として渡された配列を文字列として表現する。
Arrays.sort(変数名);//引数として渡された配列を昇順でソートする。
Arrays.sort(変数名, Collections.reverseOrder())//引数として渡された配列を降順でソートする。
//変数の型はラッパークラス型て指定する。

java.ioパッケージ//input,outputを扱う標準API
//標準入力...コンピューターにおける入力装置など、データの入力元のことを指す。
//以下、標準入力に必要なパッケージ。
//java.io.BufferedReader...入力した文字列を１行丸ごと読み込む。
//java.io.InputStreamReader...入力値を文字列として受け取る。
//java.io.IOException...inputとoutputに関する例外。
//java.lang.System.in...入力を受け付ける。デフォルトでimport済み。
クラスの準備//以下３行を丸暗記する。
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
クラスの利用
String line = br.readLine();//入力処理と入力値の取得。
//キーボードで入力した値がlineに格納される
例外対策
public static void main(String[] args) throws IOException {//readLine()を呼び出す際は必ず入れる。
  //readLine()を呼び出す処理
}


java.timeパッケージ

LocalDateTimeクラス//日付と日時を扱うためのクラス。
//参考リンク:https://docs.oracle.com/javase/jp/8/docs/api/java/time/LocalDateTime.html
//staticなのでインスタンス生成をしなくても使える。

static LocalDateTime now()
LocalDateTime dateTime = LocalDateTime.now();//現在の時間を年月日、時間分秒ナノ秒のフォーマットでLocalDateTimeオブジェクトを生成し、取得する。

static LocalDateTime of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)//年月日、時分秒ナノ秒まで指定してLocalDateTimeクラスのオブジェクトを指定する。
LocalDateTime dateTime = LocalDateTime.of(引数);
//引数に第一引数、第二引数...というように、日時の情報を入力する。

static LocalDatetime parse(Charsequence text)
//2023-11-11T00:47:27のようなフォーマットを利用してLocalDateTimeオブジェクトを生成し、取得する。
LocalDateTime dateTime = LocalDateTime.parse("年-月-日T時-分-秒");
int getYear()
//LocalDateTimeより年を取得する。
int 変数名 = dateTime.getYear();//変数dateTimeに格納された情報を取り出すメソッド。
//そのほか、
int getMonthValue()//月
int getDayOfMonth()//その月の日付
int getDayOfYear()//その年の日付
int getHour()//時間
int getMinute()//分
int getSecond()//秒
int getNano()//ナノ秒
//などがある。

LocalDateTime plusDays(long days)
//LocalDateTimeオブジェクトに保存している日時に対して、引数により指定した日数分加算し、新たなオブジェクトを返却する。
LocalDateTime 変数名 = dateTime.plusDays(引数);
//そのほか、
getHours()
getMonths()
//などがある。

LocalDateTime minusDays(long days)
//LocalDateTimeオブジェクトに保存している日時に対して、引数により指定した日数分減算し、新たなオブジェクトを返却する。
LocalDateTime 変数名 = dateTime.minusDay(引数);
//その他、
minusHours()
minusMonths()
//などがある。

LocalDateTime withDayOfMonth(long days)
//LocalDateTimeオブジェクトに保存している日時に対して、引数により指定した日付に変更し、新たなオブジェクトを返す。
LocalDateTime dateTime = dateTime.withDayOfMonth(引数);
//その他、
withMonth()
withHour()
//などがある。


DateTimeFormatterクラス//日時に利用する文字列のフォーマットを変更するクラス。
参考リンク:https://docs.oracle.com/javase/jp/8/docs/api/java/time/format/DateTimeFormatter.html

//パターン文字
y//年
M//月
d//日
H//時
m//分
s//秒
h//時間を12時間表記にする

static DateTimeFormatter ofPattern(String pattern)
//指定したパターンのDateTimeFormatterオブジェクトを用意する。
DateTimeFormatter format = DateTimeFormatter.ofPattern("(パターン文字で表記を指定)");

static LocalDateTime parse(CharSequence text, DateTimeFormatter)
//parse()にはオーバーロードが用意されており、DateTimeFormatterオブジェクトを引数に持たせることで、別のフォーマットの文字列からLocalDateTimeオブジェクトを生成する。
//例）
DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");//
LocalDateTime dateTime = LocalDateTime.parse("(年月日時分秒を記入)", format);//2000-01-23T01:23:45と出力。

String format(DateTimeFormatter formatter)
//LocalDateTimeオブジェクトを所定のフォーマットを利用した文字列として返却する。
//例）
DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分ss秒");
LocalDateTime dateTime = LocalDateTime.of(2000, 1, 23, 1, 23, 45);//2000-01-23T01:23:45
String formatDate = dateTime.format(format);//2000年01月23日 01時23分45秒
//変数formatに指定した形式に変換して文字列として返す。


java.util.Arraylist
//要素の追加や削除が行える、長さが可変となる配列。
クラスの読み込み
import java.util.ArrayList;
import java.util.List;//インターフェイスの一つでArrayListやLinkedListなど...Listと名のつくクラスの共通処理を宣言している。
変数の宣言
//値の型を List<保存したい参照型名> に、値を new ArrayList<保存したい参照型名>();とする。
//例）List<String> list = new ArrayList<String>();
ジェネリクス
//<>に保存する値の型を指定する機能
//型に対応したラッパークラスを指定する。

add(E element)
//ArrayListに要素を追加する。
//例）
List<Integer> numList = new ArrayList <Integer>();
numList.add(1);
numList.add(2);
numList.add(3);
numList.add(4);

set(int index, E element)
//ArrayListに保存済みの要素をインデックス指定で任意の要素に書き換える。
//例）
List<Integer> numList = new ArrayList<Integer>();
numList.add(1);
numList.set(0, 10);//0番目の要素を10にする。

remove(int index)
//ArrayListの要素の内、引数で指定したキーの要素の削除を行う。
//削除すると後続の要素は左に移動する。(キーを１減算)
//例）
numList.remove(1);//2が削除される。

get(int index)
//ArrayListの要素の取得をする。
//要素の追加時に割り振られたインデックス番号をint型の値で指定する。
//例）
numList.get(0);//1
numList.get(1);//2
numList.get(2);//3
numList.get(3);//4

size()
//ArrayListに保存している要素数を返す。
//例）
numList.size();//4

indexOf(Object o)
//指定された要素がリスト内で最初に検出された位置のインデックスを返す。
//指定された要素がリストにない場合は -1 を返す。
//例）
numList.indexOf(1);//0

isEmpty()
//リストが要素を一つも保持していない場合は true を返し、要素がある場合に false を返す。
//例）
List<String> strList = new ArrayList<String>();
strList.isEmpty();//true
strList.add("a");
strList.isEmpty();//false


Arrayリストの繰り返し
//例）
for (int i = 0; i < strList.size(); i++) { //strList.sizeで要素数を取得できる。
    System.out.print(strList.get(i) + " ");
}


forEach
//引数に処理を定義する。
//ArrayListの繰り返しに対してはあらかじめラムダ式を利用できるようになっている。
//例）
strList.forEach( str -> { //拡張for文同様の動きをする。
    System.out.print(str + " ");
});


ラムダ式
//メソッドのような処理を一つのオブジェクトとして扱うことができる。
//変数はラムダ式のスコープ内のみで有効。

左辺//アロー演算子 -> を挟んで左辺は処理内で利用する引数を指定する。
変数名 -> 処理//引数の型を省略可能。
(引数1, 引数2) -> 処理//引数が一つの場合は()を省略可能。

右辺//処理を記述する。

省略機能
変数名 -> 処理//処理が１文の場合(return文なし)、{}とセミコロンを省略可能。
変数名 -> 変数名 * 変数名//処理が１文の場合(return文あり)、{}とセミコロンとreturnを省略可能。


java.util.HashMap;
java.util.Map;
//連想配列
//インデックス...キー
//要素...バリュー
インスタンスの生成
Map<キーの型, 値の型> 変数名 = new HashMap<キーの型, 値の型>();
//型にはラッパークラス以外の他の参照型も指定できる。
マッピング
インスタンス名.put(キー名, 値);
//すでにマッピングされているキーを指定した場合上書きされる。
上書き
インスタンス名.replace(キー名, 値);
削除
インスタンス名.remove(キー名);
要素の数の取得
インスタンス名.size();
要素の中身の有無の確認
インスタンス名.isEmpty();//要素を一つでも保持している場合はtrue。
HashMapの繰り返し
インスタンス名.forEach((キー名, 値) -> {
    //処理
})


java.util.Set;
//マップに含まれているキーの一覧をSetというコレクションで返す。
フィールドの定義
Set<型> 変数名1 = 変数名.Keyset();//値のみ返す。
拡張for文による繰り返し処理の例
for (型 変数名2 : 変数名1) {
    System.out.println(変数名2);
}


java.util.HashSet;
java.util.Set;
//重複要素を持たないコレクション。
//キーを持たない。
//とりあえず要素をまとめたい時に使う。
インスタンスの生成
Set<型> 変数名 = new HashSet<型>();
要素の追加
set.add(値);//同じ値の要素は保存されない。
要素の有無の確認
set.contains(値);//指定値が存在すればtrue。
HashSetに指定したコレクション内の値が、全て含まれているかを確認する
set.containsAll(変数名);//変数名の配列がHashSet内の要素で構成されていればtrue。
削除
set.remove(値);
要素数の取得
set.size();
要素の保持の有無
set.isEmpty(値);//指定した値があればtrue。
配列化
Integer[] 配列化後の変数名 = 配列化前の変数名.toArray(new Integer[配列化前の変数名.size()]);
