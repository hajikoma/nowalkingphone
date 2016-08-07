package com.hajikoma.nowalkingphone;

import android.graphics.Rect;

import com.hajikoma.nowalkingphone.framework.Graphics;
import com.hajikoma.nowalkingphone.framework.Pixmap;
import com.hajikoma.nowalkingphone.framework.impl.AndroidGame;

/**
 * 「歩きスマホする者」を表すクラス。
 * 状態によってさまざまなアクションをする。
 */
public class SmaphoWalker extends Walker {


    /**
     * SmaphoWalkerを生成する。
     *
     * @param visual    Walkerの画像セット（スプライト画像）
     * @param rowHeight visualの中の、一画像の高さ
     * @param colWidth  visualの中の、一画像の幅
     * @param location  描画先矩形座標
     */
    public SmaphoWalker(String name, int hp, int speed, int power, String description, int point,
                        Pixmap visual, Integer rowHeight, Integer colWidth, Rect location) {
        super(name, hp, speed, power, description, point, visual, rowHeight, colWidth, location);
    }


    /**
     * ふらふら歩く
     */
    @Override
    protected void walk() {
        if (dstRect.top <= AndroidGame.TARGET_HEIGHT) {
            if (actionTime <= 0.3f) {
//                drawAction(0, 1);
                drawAction(0, 0);
                move(1, speed);
            } else if (actionTime <= 0.6f) {
//                drawAction(0, 1);
                drawAction(0, 0);
                move(-1, speed);
            } else {
                loopAction();
                walk();
            }

            // たまに立ち止まる
            if (Math.random() > 0.999) {
                setState(ActionType.STOP);
            }
        } else {
            vanish();
        }
    }
}
