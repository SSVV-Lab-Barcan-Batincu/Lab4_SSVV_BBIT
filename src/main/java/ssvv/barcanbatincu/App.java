package ssvv.barcanbatincu;

import ssvv.barcanbatincu.controller.StudentController;
import ssvv.barcanbatincu.ui.UI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        StudentController studentController = new StudentController();
        UI ui = new UI(studentController);
        ui.menu();
    }
}
