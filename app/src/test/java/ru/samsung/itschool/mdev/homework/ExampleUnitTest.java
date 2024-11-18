package ru.samsung.itschool.mdev.homework;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;
import org.robolectric.android.controller.ActivityController;

@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {
    public static final String ZERO = "0.0";
    public static final String NEG_ONE = "-1.0";
    public static final String ONE = "1.0";
    public static final String TWO = "2.0";
    public static final String ANY = "any";
    public static final String NONE = "none";
    static StringBuffer sb;
    static int salt;

    @BeforeClass
    public static void report() {
        salt = new Random(System.currentTimeMillis()).nextInt(999);
        sb = new StringBuffer();
        sb.append(String.format("%03d", salt));
    }

    @Test
    public void testButton1() {
        try (ActivityController<MainActivity> ctrl = Robolectric.buildActivity(MainActivity.class)) {
            MainActivity activity = ctrl.create().get();
            Button view = activity.findViewById(R.id.run);
            Assert.assertNotNull(view);
            EditText et_a = activity.findViewById(R.id.a);
            Assert.assertNotNull(et_a);
            EditText et_b = activity.findViewById(R.id.b);
            Assert.assertNotNull(et_b);
            EditText et_c =  activity.findViewById(R.id.c);
            Assert.assertNotNull(et_c);
            TextView tv = activity.findViewById(R.id.res);
            Assert.assertNotNull(tv);
            et_a.setText(ZERO);
            et_b.setText(ZERO);
            et_c.setText(ZERO);
            view.performClick();
            org.junit.Assert.assertEquals(tv.getText().toString(), ANY);
            sb.append(",OK");
        } catch (Throwable ignored) {
        }
    }

    @Test
    public void testButton2() {
        try (ActivityController<MainActivity> ctrl = Robolectric.buildActivity(MainActivity.class)) {
            MainActivity activity = ctrl.create().get();
            Button view = activity.findViewById(R.id.run);
            Assert.assertNotNull(view);
            EditText et_a = activity.findViewById(R.id.a);
            Assert.assertNotNull(et_a);
            EditText et_b = activity.findViewById(R.id.b);
            Assert.assertNotNull(et_b);
            EditText et_c = activity.findViewById(R.id.c);
            Assert.assertNotNull(et_c);
            TextView tv = activity.findViewById(R.id.res);
            Assert.assertNotNull(tv);
            et_a.setText(NEG_ONE);
            et_b.setText(TWO);
            et_c.setText(ZERO);
            view.performClick();
            String[] s = tv.getText().toString().trim().replaceAll(" +", " ").split(" ");
            double r1 = Double.parseDouble(s[0]);
            double r2 = Double.parseDouble(s[1]);
            if (r1 > r2) {
                org.junit.Assert.assertEquals(2, r1, 0.001);
                org.junit.Assert.assertEquals(0, r2, 0.001);
            } else {
                org.junit.Assert.assertEquals(0, r1, 0.001);
                org.junit.Assert.assertEquals(2, r2, 0.001);
            }
            sb.append(",OK");
        } catch (Throwable ignored) {
        }
    }

    @Test
    public void testButton3() {
        try (ActivityController<MainActivity> ctrl = Robolectric.buildActivity(MainActivity.class)) {
            MainActivity activity = ctrl.create().get();
            Button view = activity.findViewById(R.id.run);
            Assert.assertNotNull(view);
            EditText et_a = activity.findViewById(R.id.a);
            Assert.assertNotNull(et_a);
            EditText et_b = activity.findViewById(R.id.b);
            Assert.assertNotNull(et_b);
            EditText et_c = activity.findViewById(R.id.c);
            Assert.assertNotNull(et_c);
            TextView tv = activity.findViewById(R.id.res);
            Assert.assertNotNull(tv);
            et_a.setText(ONE);
            et_b.setText(TWO);
            et_c.setText(TWO);
            view.performClick();
            org.junit.Assert.assertEquals(tv.getText().toString(), NONE);
            sb.append(",OK");
        } catch (Throwable ignored) {
        }
    }

    @AfterClass
    public static void printResult() {
        System.err.println("\n\n=============================\nВАШ РЕЗУЛЬТАТ: " + sb.toString().hashCode() + salt + "\n=============================\n");

    }
}