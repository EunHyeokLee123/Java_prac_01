package oop.Quiz_inter.Quiz_01;

public class AudioPlayer implements MediaPlayable{

    @Override
    public void play() {
        System.out.println("오디오가 재생됩니다.");
    }

    @Override
    public void pause() {
        System.out.println("오디오가 일시정지됩니다.");
    }

    @Override
    public void stop() {
        System.out.println("오디오가 종료됩니다.");
    }
}
