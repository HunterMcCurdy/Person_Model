import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {

    private String firstname;
    private String lastname;
    private String id;
    private int YOB;
    private String title;
    private String fullname;

    public PersonGenerator(String firstname, String lastname, String id, int YOB, String title) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.YOB = YOB;
        this.title = title;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return id + " " + firstname + " " + lastname + " " + title + " " + YOB;
    }

    public String fullname() {
        return firstname + " " + lastname;
    }

    public String formalname() {
        return title + " " + fullname();
    }

    public int getage()
    {
        return 2023-YOB;
    }

    public int getage(int year)
    {

        return year-YOB;
    }


    public static void main(String[] args)
    {
        ArrayList<String> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\PersonTestData.txt");


        PersonGenerator Hunter = new PersonGenerator("Hunter", "McCurdy", "000001", 2006, "Mr");
        folks.add(String.valueOf(Hunter));


        PersonGenerator Austin = new PersonGenerator("Austin", "Iles", "000002", 2007, "Mr");
        folks.add(String.valueOf(Austin));


        for( String p: folks)
            System.out.println(p);
            System.out.println(Hunter.fullname());
            System.out.println(Hunter.formalname());
            System.out.println(Hunter.getage());
            System.out.println(Hunter.getage(2016));

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String rec: folks)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written!");


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
