
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Scanner;

import java.util.Properties;

    public class Producer {
        public static void main(String[] args){
            // For example 192.168.1.1:9092,192.168.1.2:9092
            Properties properties = new Properties();
            properties.put("bootstrap.servers", "localhost:9092");
            properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            Scanner in  = new Scanner(System.in);
            KafkaProducer kafkaProducer  = new KafkaProducer(properties);
            try{
                for(int i = 1; i < 2; i++){
                    System.out.println("Enter Records : ");
                    System.out.println("ID= ");
                    int id=in.nextInt();
                    System.out.println("Enter Name : ");
                    String name=in.next();
                    System.out.println("Enter Age : ");
                    int age=in.nextInt();
                    System.out.println("Enter Course : ");
                    String Course=in.next();
                    String rec=Integer.toString(id)+" "+name+" "+Integer.toString(age)+" "+Course;
                    kafkaProducer.send(new ProducerRecord("user", Integer.toString(i), "Record " + rec ));
                }


            }catch (Exception e){
                e.printStackTrace();
            }finally {
                kafkaProducer.close();
            }
        }
    }



