package oop.Quiz_inter.Quiz_01;

public class MediaPlayer {
    private MediaPlayable[] mediaList = new MediaPlayable[0];

    public void addMedia(MediaPlayable media) {
        // 주어진 media를 mediaList배열에 추가
        MediaPlayable[] mediaArr = new MediaPlayable[mediaList.length + 1];
        for (int i = 0; i < mediaList.length; i++) {
            mediaArr[i] = mediaList[i];
        }
        mediaArr[mediaList.length] = media;
        mediaList = mediaArr;
    }

    public void playAll() {
        // 반복문을 통해 mediaList에 있는 모든 미디어들을 재생시킴
        for (MediaPlayable mediaPlayable : mediaList) {
            mediaPlayable.play();
        }
    }
}
