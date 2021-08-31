package com.gracefulfuture.data.structure.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
* @description      元素类
* @author           chenkun
* @create           2021/5/27 17:11
* @version          1.0
*/
public class Element implements Delayed {
    private String name;

    private long delay;

    public Element() {
    }

    public Element(String name,long delay) {
        this.name = name;
        this.delay = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(delay > 0 ? delay : 0);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == this) {
            return 0;
        }
        Element element = (Element) o;
        long diff = this.getDelay(TimeUnit.MILLISECONDS) - element.getDelay(TimeUnit.MILLISECONDS);
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public void printInfo() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        System.out.println("元素" + getName() + "在" + seconds + "秒被删除");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", delay=" + delay +
                '}';
    }
}
