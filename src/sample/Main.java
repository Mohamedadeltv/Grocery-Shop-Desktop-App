package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.WhileNode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Main extends Application {
    Owner o=Owner.getInstance();
    Manager [] manager= {new Manager("Ahmed","5th street","01235674","male"), new Manager("Youssef","6th street","01234244","male")};
    Worker [] worker ={new Worker("Morsy","Smouha","0111222","Male"), new Worker("Ali","Roshdy","01567555","Male")};





    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane p = new GridPane();
        p.setAlignment(Pos.CENTER);
        p.setHgap(10);
        p.setVgap(10);

        p.add(new Label("Owner name: "),0,0);
        TextField name= new TextField();
        p.add(name,1,0);
        Label address=new Label("Adress");
        p.add(address,0,3);
        Label telephone= new Label("Telephone");
        p.add(telephone,1,3);
        name.setOnAction(event -> {
            if(name.getText().equals("Mark"))
            {
                address.setText(o.getAddress());
                telephone.setText(o.getTelephonenumber());
            }
            else
            {
                address.setText("Owner not found");
                telephone.setText("Owner not found");
            }
        });
        p.add(new Label("Manager name"),0,5);
        TextField ManagerName = new TextField();
        p.add(ManagerName,1,5);
        p.add(new Label("Hours Worked"),0,6);
        TextField hours = new TextField();
        p.add(hours,1,6);
        Label ManagerAddress = new Label("Address");
        p.add(ManagerAddress,0,8);
        Label ManagerNumber= new Label("Telephone");
        p.add(ManagerNumber,1,8);
        Label ManagerSalary = new Label("The Salary");
        p.add(ManagerSalary,2,8);
        Button bmanager = new Button("Find Manager");
        p.add(bmanager,3,5);
        bmanager.setOnAction(event -> {
            File managers= new File("ManagersInfo");
            PrintWriter output = null;
            try {
                output = new PrintWriter(managers);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int i=0;
            while(i< manager.length)
            {
                if (manager[i].name.equals(ManagerName.getText()))
                {
                    ManagerAddress.setText(manager[i].address);
                    ManagerNumber.setText(manager[i].telephonenumber);
                   double hour=Double.parseDouble(hours.getText());
                    manager[i].calcbonus(hour);
                    ManagerSalary.setText(""+manager[i].getsalary());
                    output.print(ManagerName.getText());
                    output.println("  "+ManagerSalary.getText());
                    output.close();

                    break;
                }
                else
                {
                    ManagerAddress.setText("Manager not found");
                    ManagerNumber.setText("Manager not found");
                    ManagerSalary.setText("Manager not found");
                }
                i++;
            }

        });
        p.add(new Label("Worker name "),0,10);
        TextField workername = new TextField();
        p.add(workername,1,10);
        p.add(new Label("Hours Worked"),0,11);
        TextField hoursworked = new TextField();
        p.add(hoursworked,1,11);
        Label workeraddress = new Label("Address");
        p.add(workeraddress,0,13);
        Label workernumber= new Label("Telephone");
        p.add(workernumber,1,13);
        Label workersalary = new Label("Salary");
        p.add(workersalary,2,13);
        Button bworker = new Button("Find Worker");
        p.add(bworker,3,10);
        bworker.setOnAction(event -> {
            int j=0;
            while(j< worker.length)
            {
                if (worker[j].name.equals(workername.getText()))
                {
                    workeraddress.setText(worker[j].address);
                    workernumber.setText(worker[j].telephonenumber);
                    double hour=Double.parseDouble(hoursworked.getText());
                    worker[j].calcbonus(hour);
                    workersalary.setText(""+worker[j].getsalary());
                    break;
                }
                else
                {
                    workeraddress.setText("Worker not found");
                    workernumber.setText("Worker not found");
                    workersalary.setText("Worker not found");
                }
                j++;
            }

        });
        Button next = new Button("To The Orders");
        p.add(next ,4,0);
        next.setOnAction(event -> {
            Stage s2= new Stage();
            GridPane g= new GridPane();
            g.setAlignment(Pos.BASELINE_LEFT);
            g.setVgap(15);
            g.setHgap(7);
//        g.getStylesheets().add("TextField.css");


            g.add(new Label("Drinks"),1,0);
            CheckBox mojito= new CheckBox("mojito");
            CheckBox Pina_colada = new CheckBox("Pinacolada");
            CheckBox milkshake= new CheckBox("milkshake");
            CheckBox ice_tea= new CheckBox("ice tea");
            g.add(mojito,1,2); TextField mojitotext= new TextField(" "); mojitotext.setMaxSize(35,30); g.add(mojitotext,2,2);
            g.add(Pina_colada,1,3); TextField pinatext= new TextField(" "); pinatext.setMaxSize(35,30); g.add(pinatext,2,3);
            g.add(milkshake,1,4); TextField milkshaketext= new TextField(" "); milkshaketext.setMaxSize(35,30); g.add(milkshaketext,2,4);
            g.add(ice_tea,1,5); TextField iceteatext= new TextField(" "); iceteatext.setMaxSize(35,30); g.add(iceteatext,2,5);
            CheckBox pepsi= new CheckBox("pepsi");
            CheckBox redbull = new CheckBox("redbull");
            CheckBox spirit= new CheckBox("spirit");
            CheckBox apple_fanta= new CheckBox("apple fanta");
            g.add(new Label("Soft Drinks"),4,0);
            g.add(pepsi,4,2); TextField pepsitext= new TextField(" "); pepsitext.setMaxSize(35,30); g.add(pepsitext,5,2);
            g.add(redbull,4,3); TextField redbulltext= new TextField(" "); redbulltext.setMaxSize(35,30); g.add(redbulltext,5,3);
            g.add(spirit,4,4); TextField spirittext= new TextField(" "); spirittext.setMaxSize(35,30); g.add(spirittext,5,4);
            g.add(apple_fanta,4,5); TextField applefantatext= new TextField(" "); applefantatext.setMaxSize(35,30); g.add(applefantatext,5,5);
            g.add(new Label("Food"),7,0);
            CheckBox Cheese_Burger= new CheckBox("Cheese Burger");
            CheckBox Mushrom_Burger = new CheckBox("Mushrom Burger");
            CheckBox Fried_chicken= new CheckBox("Fried chicken");
            CheckBox Grilled_chiceken= new CheckBox("Grilled CHicken");
            g.add(Cheese_Burger,7,2); TextField Cheese_Burgertext= new TextField(" ");Cheese_Burgertext.setMaxSize(35,30); g.add(Cheese_Burgertext,8,2);
            g.add(Mushrom_Burger,7,3);TextField Mushrom_Burgertext= new TextField(" ");Mushrom_Burgertext.setMaxSize(35,30); g.add(Mushrom_Burgertext,8,3);
            g.add(Fried_chicken,7,4); TextField Fried_chickentext= new TextField(" ");Fried_chickentext.setMaxSize(35,30); g.add(Fried_chickentext,8,4);
            g.add(Grilled_chiceken,7,5);TextField Grilled_chicekentext= new TextField(" ");Grilled_chicekentext.setMaxSize(35,30); g.add(Grilled_chicekentext,8,5);
            g.add(new Label("appetizers"),10,0);
            CheckBox Fries= new CheckBox("Fries");
            CheckBox Onion_rings = new CheckBox("Onion Rings");
            CheckBox Nachos= new CheckBox("Nachos");
            CheckBox Curly_Fries= new CheckBox("Curly fries");
            g.add(Fries,10,2); TextField Friestext= new TextField(" "); Friestext.setMaxSize(35,30); g.add(Friestext,11,2);
            g.add(Onion_rings,10,3); TextField OnionRingstext= new TextField(" "); OnionRingstext.setMaxSize(35,30); g.add(OnionRingstext,11,3);
            g.add(Nachos,10,4); TextField Nachostext= new TextField(" "); Nachostext.setMaxSize(35,30); g.add(Nachostext,11,4);
            g.add(Curly_Fries,10,5); TextField Curlyfriestext= new TextField(" "); Curlyfriestext.setMaxSize(35,30); g.add(Curlyfriestext,11,5);
            TextField prices = new TextField(" ");
            g.add(prices,1,6);
            TextField priceafterdiscount=new TextField(" ");
            priceafterdiscount.setVisible(false);
            g.add(priceafterdiscount,2,6);
            Button totalpricesbutton= new Button("total prices");
            g.add(totalpricesbutton,1,7);
            g.add(new Label("add a promocode if you have one"),1,8);
            Button promobutton= new Button("check");
            g.add(promobutton,2,9);
            TextField promocodes = new TextField("");
            g.add(promocodes,1,9);
            TextField name1=new TextField("");
            name1.setVisible(false);
            g.add(name1,2,10);
            Label namelabel=new Label("name:");
            namelabel.setVisible(false);
            g.add(namelabel,1,10);
            TextArea chart = new TextArea("BAG\n");
            chart.setPrefSize(200,200);
            g.add(chart,1,10);

            totalpricesbutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    double sum=0;
                    String s=" ";
                    if(mojito.isSelected()){
                        double number= Double.parseDouble(mojitotext.getText());
                        item d=new drinks(mojito.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Pina_colada.isSelected()){
                        double number= Double.parseDouble(pinatext.getText());
                        item d=new drinks(Pina_colada.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(milkshake.isSelected()){
                        double number= Double.parseDouble(milkshaketext.getText());
                        item d=new drinks(milkshake.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(ice_tea.isSelected()){
                        double number= Double.parseDouble(iceteatext.getText());
                        item d=new drinks(ice_tea.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(pepsi.isSelected()){
                        double number= Double.parseDouble(pepsitext.getText());
                        item d=new drinks(pepsi.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(redbull.isSelected()){
                        double number= Double.parseDouble(redbulltext.getText());
                        item d=new drinks(redbull.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(spirit.isSelected()){
                        double number= Double.parseDouble(spirittext.getText());
                        item d=new drinks(spirit.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(apple_fanta.isSelected()){
                        double number= Double.parseDouble(applefantatext.getText());
                        item d=new drinks(apple_fanta.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Cheese_Burger.isSelected()){
                        double number= Double.parseDouble(Cheese_Burgertext.getText());
                        item d=new food(Cheese_Burger.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Mushrom_Burger.isSelected()){
                        double number= Double.parseDouble(Mushrom_Burgertext.getText());
                        item d=new food(Mushrom_Burger.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Fried_chicken.isSelected()){
                        double number= Double.parseDouble(Fried_chickentext.getText());
                        item d=new food(Fried_chicken.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);;
                    }
                    if(Grilled_chiceken.isSelected()){
                        double number= Double.parseDouble(Grilled_chicekentext.getText());
                        item d=new food(Grilled_chiceken.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Fries.isSelected()){
                        double number= Double.parseDouble(Friestext.getText());
                        item d=new appetizers(Fries.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Onion_rings.isSelected()){
                        double number= Double.parseDouble(OnionRingstext.getText());
                        item d=new appetizers(Onion_rings.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Nachos.isSelected()){
                        double number= Double.parseDouble(Nachostext.getText());
                        item d=new appetizers(Nachos.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }
                    if(Curly_Fries.isSelected()){
                        double number= Double.parseDouble(Curlyfriestext.getText());
                        item d=new appetizers(Curly_Fries.getText(),number);
                        sum+=d.pricing(number);
                        prices.setText(""+ sum);
                        s+=d.getName()+" quantity"+ d.quantity+"\n";
                        chart.setText(""+s);
                    }






                }
            });
            promobutton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    discounts d1= new discounts(String.valueOf(name1.getText()),String.valueOf(promocodes.getText()));
                    if(d1.promo()!=0) {
                        if(d1.promo()==0.3) {
                            name1.setVisible(true);
                            namelabel.setVisible(true);
                            g.getChildren().remove(chart);
                            g.add(chart, 1, 11);
                        }
                        d1= new discounts(String.valueOf(name1.getText()),String.valueOf(promocodes.getText()));
                        double discount1 = (Double.parseDouble(prices.getText()) - (Double.parseDouble(prices.getText()) * d1.dsa()));
//                String discount2=String.valueOf(discount1);
                        priceafterdiscount.setVisible(true);
                        priceafterdiscount.setText(String.valueOf(discount1));
                    }
                    else{
                        priceafterdiscount.setVisible(false);
                        promocodes.setVisible(false);
                        promobutton.setVisible(false);
                        g.getChildren().remove(chart);
                        g.add(chart, 1, 8);

                    }



                }
            });




            GridPane pane3 = new GridPane();
            pane3.setAlignment(Pos.CENTER);
            pane3.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
            pane3.setHgap(10);
            pane3.setVgap(7);

            Button Dilvery=new Button("DILVERY");
            Dilvery.maxWidth(10);
            Dilvery.setMaxSize(100,100);
            Dilvery.setPadding(new Insets(10));
            pane3.add(Dilvery,2,0);
            Dilvery.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Label x=new Label("Name");
                    Label y=new Label("Phone");
                    Label z=new Label("Address");
                    pane3.add(x,2,10);
                    pane3.add(y,2,11);
                    pane3.add(z,2,12);
                    TextField name=new TextField("   ");
                    TextField phone=new TextField("   ");
                    TextField address=new TextField("   ");
                    pane3.add(name,4,10);
                    pane3.add(phone,4,11);
                    pane3.add(address,4,12);
                    Button sumbit=new Button("Submit");
                    pane3.add(sumbit,5,11);
                    sumbit.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            TextArea chart3 = new TextArea("   ");
                            chart3.setPrefSize(400,800);
                           // chart3.set(Pos.TOP_LEFT);
                            pane3.add(chart3,8,10);
                            //double number= Double.parseDouble(phone.getText());
                            double number2= Double.parseDouble(prices.getText())+10.0;
                            chart3.setText("name:"+name.getText()+"\n"+"phone:"+phone.getText()+"\n"+"address:"+address.getText()+"\n"+"total price +Dilvery Fees (10 LE): " +number2);
                        }
                    });
                }
            });

            Button Dine_In=new Button("DINE IN");
            Dine_In.maxWidth(10);
            Dine_In.setMaxSize(100,100);
            Dine_In.setPadding(new Insets(10));
            pane3.add(Dine_In,2,1);


            Dine_In.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    Label l2=new Label("how many person?");
                    TextField TFMI2=new TextField("   ");
                    pane3.add(l2,2,10);
                    pane3.add(TFMI2,2,11);
                    Button enter2=new Button("Enter");
                    pane3.add(enter2,2,14);
                    enter2.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            DineIn y=new DineIn();
                            double no=Double.parseDouble(TFMI2.getText());
                            double x=y.Table_number(no);
                            double z=Double.parseDouble(prices.getText());
                            z=z+25.0;
                            TextField chart3=new TextField();
                            chart3.setPrefSize(500,400);
                            //chart3.setMaxWidth(300);


                            pane3.add(chart3,12,10);
                            chart3.setText("table Number  "+x+ "\n"+ "  Total price include Taxes" +z);



                        }
                    });

                }
            });







            Button TAKEAWAY=new Button("TAKE AWAY");
            TAKEAWAY.maxWidth(10);
            TAKEAWAY.setMaxSize(100,100);
            Dine_In.setPadding(new Insets(10));
            pane3.add(TAKEAWAY,2,3);


            TAKEAWAY.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    double x=Double.parseDouble(prices.getText());
                    TextField F2=new TextField("  ");
                    F2.setText("@@@ Take Away@@@ "+"total =" + x);
                    F2.setMaxSize(1000,1000);
                    F2.setPrefSize(300,50);

                    pane3.add(F2,2,13);


                }
            });

            GridPane.setHalignment(Dilvery, HPos.CENTER);
            GridPane.setHalignment(Dine_In, HPos.CENTER);
            GridPane.setHalignment(TAKEAWAY, HPos.CENTER);


            GridPane meals=new GridPane();
            meals.setHgap(5);
            meals.setVgap(5);
            Button meal1=new Button("Meal 1");
            meals.add(meal1,10,11);
            meal1.centerShapeProperty();
            meal1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Meals meal=new Meals();
                    double x=meal.meals(1);
                    //TextField TFMI3=new TextField("2 Fries +2 Grilled chiken + 2 pepsi");
                    // meals.add(TFMI3,11,13);
                    prices.setText(""+x);
                    chart.setText("2 Fries +2 Grilled Chicken+ 2 pepsi");

                }
            });


            Button meal2=new Button("Meal 2");
            meals.add(meal2,10,12);
            meal2.centerShapeProperty();
            meal2.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Meals meal=new Meals();
                    double q=meal.meals(2);
                    //TextField TFMI3=new TextField("2 Fries +2 Grilled chiken + 2 pepsi");
                    // meals.add(TFMI3,11,13);
                    prices.setText(""+q);
                    chart.setText("2 Fries +2 Fried Chicken+ 2 pepsi");

                }
            });

            BorderPane f=new BorderPane();
            f.setTop(g);
            f.setCenter(pane3);

            s2.setTitle("Orders");
            s2.setScene(new Scene(f, 1000, 1000));
            s2.show();
        }
    );



        primaryStage.setTitle("The Staff");
        primaryStage.setScene(new Scene(p, 800, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);



    }
}
