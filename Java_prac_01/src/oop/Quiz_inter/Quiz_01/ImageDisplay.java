package oop.Quiz_inter.Quiz_01;

public class ImageDisplay implements MediaPlayable{

    @Override
    public void play() {
        System.out.println("이미지가 재생됩니다.");
    }

    @Override
    public void pause() {
        System.out.println("이미지가 일시정지됩니다.");
    }

    @Override
    public void stop() {
        System.out.println("이미지가 종료됩니다.");
    }
}
