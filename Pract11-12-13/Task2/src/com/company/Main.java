package com.company;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.*;
import java.util.*;

 interface Behavior {
    public String getBehavior();
    public String getCapital();
}
 class EnglishBehavior implements Behavior{
    public EnglishBehavior() {
    }
    public String getBehavior(){
        return "English behavior";
    }
    public String getCapital(){
        return "London";
    }
}
 class RussianBehavior implements Behavior {
    public RussianBehavior() {
    }
    public String getBehavior(){
        return "Русский вариант поведения";
    }
    public String getCapital(){
        return "Москва";
    }
}
 class MyResourceBundle_ru_RU extends ResourceBundle {
    Hashtable bundle = null;
    public MyResourceBundle_ru_RU() {
        bundle = new Hashtable();
        bundle.put("Bundle description","Набор ресурсов для русской локали");
        bundle.put("Behavior",new RussianBehavior());
    }
    public Enumeration getKeys() {
        return bundle.keys();
    }
    protected Object handleGetObject(String key) throws
            java.util.MissingResourceException {
        return bundle.get(key);
    }
}

 class MyResourceBundle_en_EN extends ResourceBundle {
    Hashtable bundle = null;
    public MyResourceBundle_en_EN() {
        bundle = new Hashtable();
        bundle.put("Bundle description","English resource set");
        bundle.put("Behavior",new EnglishBehavior());
    }
    public Enumeration getKeys() {
        return bundle.keys();
    }
    protected Object handleGetObject(String key) throws
            java.util.MissingResourceException {
        return bundle.get(key);
    }
}
 class MyResourceBundle extends ResourceBundle {
    Hashtable bundle = null;
    public MyResourceBundle() {
        bundle = new Hashtable();
        bundle.put("Bundle description","Default resource bundle");
        bundle.put("Behavior",new EnglishBehavior());
    }
    public Enumeration getKeys() {
        return bundle.keys();
    }
    protected Object handleGetObject(String key) throws
            java.util.MissingResourceException {
        return bundle.get(key);
    }
}

class TestObserver implements java.util.Observer {
    private String name = "";

    public TestObserver(String name) {
        this.name = name;
    }
    public void update(java.util.Observable o,Object arg) {
        String str = "Called update of " + name;
        str += " from " + ((TestObservable)o).getName();
        str += " with argument " + (String)arg;
        System.out.println(str);
    }
}

class TestObservable extends java.util.Observable {
    private String name = "";
    public TestObservable(String name) {
        this.name = name;
    }

    public void modify() {
        setChanged();
    }

    public String getName() {
        return name;
    }
}

class Test {
    public Test() {
    }

    void dumpArray(byte[] arr) {
        for(int cnt=0;cnt< arr.length;cnt++) {
            System.out.print(arr[cnt]);
        }
        System.out.println();
    }

    void dumpList(List list){
        Iterator it = list.iterator();
        System.out.println();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }
    }

    int getTime(int hour,int min,int sec,int ms){
        return hour * 3600000 + min * 60000 + sec * 1000 + ms;
    }

    String padr(String str, int len) {
        if (len - str.length() > 0) {
            char[] buf = new char[len - str.length()];
            Arrays.fill(buf, ' ');
            return str + new String(buf);
        } else {
            return str.substring(0, len);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2002);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println(" Initialy set date: " + sdf.format(cal.getTime()));
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
        System.out.println(" Date with month changed : " + sdf.format(cal.getTime()));
        cal.set(Calendar.DAY_OF_MONTH, 30);
        System.out.println(" Date with day changed : " + sdf.format(cal.getTime()));

        System.out.println();

        sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2002);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        System.out.println(" Initialy set date: " + sdf.format(cal.getTime()));
        cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
        cal.set(Calendar.DAY_OF_MONTH, 30);
        System.out.println(" Date with day and month changed : " + sdf.format(cal.getTime()));

        System.out.println();

        sdf = new SimpleDateFormat("yyyy MMMM dd HH:mm:ss");
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2002);
        cal.set(Calendar.MONTH, Calendar.AUGUST);
        cal.set(Calendar.DAY_OF_MONTH, 31);
        cal.set(Calendar.HOUR_OF_DAY, 19);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 00);
        System.out.println("Current date: " + sdf.format(cal.getTime()));
        cal.roll(Calendar.SECOND, 75);
        System.out.println("Rule 1: " + sdf.format(cal.getTime()));
        cal.roll(Calendar.MONTH, 1);
        System.out.println("Rule 2: " + sdf.format(cal.getTime()));

        System.out.println();

        Test test = new Test();
        TimeZone tz = TimeZone.getDefault();
        int rawOffset = tz.getRawOffset();
        System.out.println("Current TimeZone" + tz.getDisplayName() + tz.getID() + "\n\n");
        // Display all available TimeZones
        System.out.println("All Available TimeZones \n");
        String[] idArr = tz.getAvailableIDs();
        for (int cnt = 0; cnt < idArr.length; cnt++) {
            tz = TimeZone.getTimeZone(idArr[cnt]);
            System.out.println(test.padr(tz.getDisplayName() +
                    tz.getID(), 64) + " raw offset=" + tz.getRawOffset() +
                    ";hour offset=(" + tz.getRawOffset() / (1000 * 60 * 60) + ")");
        }
        // Display all available TimeZones same as for Moscow
        System.out.println("\n\n TimeZones same as for Moscow \n");
        idArr = tz.getAvailableIDs(rawOffset);
        for (int cnt = 0; cnt < idArr.length; cnt++) {
            tz = TimeZone.getTimeZone(idArr[cnt]);
            System.out.println(test.padr(tz.getDisplayName() +
                    tz.getID(), 64) + " raw offset=" + tz.getRawOffset() +
                    ";hour offset=(" + tz.getRawOffset() / (1000 * 60 * 60) + ")");
        }

        System.out.println();

        test = new Test();
        SimpleTimeZone stz = new SimpleTimeZone(
                TimeZone.getDefault().getRawOffset()
                ,TimeZone.getDefault().getID()
                ,Calendar.MARCH
                ,-1
                ,Calendar.SUNDAY
                ,test.getTime(2,0,0,0)
                ,Calendar.OCTOBER
                ,-1
                ,Calendar.SUNDAY
                ,test.getTime(3,0,0,0)
        );
        System.out.println(stz.toString());

        System.out.println();

        test = new Test();
        TestObservable to = new TestObservable("Observable");
        TestObserver o1 = new TestObserver("Observer 1");
        TestObserver o2 = new TestObserver("Observer 2");
        to.addObserver(o1);
        to.addObserver(o2);
        to.modify();
        to.notifyObservers("Notify argument");

        test = new Test();
        ArrayList al = new ArrayList();
        al.add("First element");
        al.add("Second element");
        al.add("Third element");
        Iterator it = al.iterator();
        while(it.hasNext()) {
            System.out.println((String)it.next());
        }
        System.out.println("\n");
        al.add(2,"Insertion");
        it = al.iterator();
        while(it.hasNext()){
            System.out.println((String)it.next());
        }

        test = new Test();
        LinkedList ll = new LinkedList();
        ll.add("Element1");
        ll.addFirst("Element2");
        ll.addFirst("Element3");
        ll.addLast("Element4");
        test.dumpList(ll);
        ll.remove(2);
        test.dumpList(ll);
        String element = (String)ll.getLast();
        ll.remove(element);
        test.dumpList(ll);

        TreeMap tm = new TreeMap();
        tm.put("key","String1");
        System.out.println(tm.get("key"));
        tm.put("key","String2");
        System.out.println(tm.get("key"));

        Properties props = new Properties();
        StringWriter sw = new StringWriter();
        sw.write("Key1 = Value1 \n");
        sw.write(" Key2 : Value2 \r\n");
        sw.write(" Key3 Value3 \n ");
        InputStream is = new ByteArrayInputStream(sw.toString().getBytes());

        try {
            props.load(is);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        props.list(System.out);
        props.setProperty("Key1","Modified Value1");
        props.setProperty("Key4","Added Value4");
        props.list(System.out);

        Random r = new Random(100);
        // Generating the same sequence numbers
        for(int cnt=0;cnt<9;cnt++){
            System.out.print(r.nextInt() + " ");
        }
        System.out.println();
        r = new Random(100);
        for(int cnt=0;cnt<9;cnt++) {
            System.out.print(r.nextInt() + " ");
        }
        System.out.println();
        // Generating sequence of bytes
        byte[] randArray = new byte[8];
        r.nextBytes(randArray);
        test.dumpArray(randArray);

        Locale l = Locale.getDefault();
        System.out.println(l.getCountry() + " " +
                l.getDisplayCountry() + " " + l.getISO3Country());
        System.out.println(l.getLanguage() + " " +
                l.getDisplayLanguage() + " " + l.getISO3Language());
        System.out.println(l.getVariant() + " " + l.getDisplayVariant());
        l = new Locale("ru","RU","WINDOWS");
        System.out.println(l.getCountry() + " " +
                l.getDisplayCountry() + " " + l.getISO3Country());
        System.out.println(l.getLanguage() + " " +
                l.getDisplayLanguage() + " " + l.getISO3Language());
        System.out.println(l.getVariant() + " " + l.getDisplayVariant());

        ResourceBundle rb =
                ResourceBundle.getBundle("lecture.MyResourceBundle", Locale.getDefault());
        System.out.println((String)rb.getObject("Bundle description"));
        Behavior be = (Behavior)rb.getObject("Behavior");
        System.out.println(be.getBehavior());
        System.out.println(be.getCapital());
        rb = ResourceBundle.getBundle("lecture.MyResourceBundle", new Locale("en","EN"));
        System.out.println((String)rb.getObject("Bundle description"));
        be = (Behavior)rb.getObject("Behavior");
        System.out.println(be.getBehavior());
        System.out.println(be.getCapital());
    }



}
