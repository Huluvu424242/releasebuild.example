package com.github.funthomas424242.releasebuild;

import org.junit.Test;

/**
 * Created by huluvu424242 on 28.11.16.
 */
public class MainTest {


    @Test
    public void testPrint_ValidInstanceCall(){
        final Main main = new Main();
        final String[] params=new String[]{"Hallo"};
        main.main(params);
    }

    @Test
    public void testPrint_ValidStaticCall(){
        Main.main(null);
    }

}
