interface Player {
    public void start();
    public void stop();
    public void pause();
    public void forward();
    public void rewind();
}

class VideoPlayer implements Player {
    @Override
    public void start() {
        System.out.println("動画を再生します。");
    }
    @Override
    public void stop() {
        System.out.println("動画を停止します。");
    }
    @Override
    public void pause() {
        System.out.println("動画を一時停止します。");
    }
    @Override
    public void forward() {
        System.out.println("動画を早送りします。");
    }
    @Override
    public void rewind() {
        System.out.println("動画を巻き戻します。");
    }
}

class Test {
    public static void main(String[] args) {
        Player videoPlayer = new VideoPlayer();//インターフェース型を指定することで、インターフェースを継承したクラスが追加された時にPlayer型の変数を通じて共通のメソッドを呼び出すことができる。
        videoPlayer.start();
        videoPlayer.stop();
        videoPlayer.pause();
        videoPlayer.forward();
        videoPlayer.rewind();
    }
}
