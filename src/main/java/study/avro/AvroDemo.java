package study.avro;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

public class AvroDemo {

	public static void main(String[] args) throws IOException {
		User u = User.newBuilder().setFavoriteNumber(7).setName("hzz").build();
		File f = new File("users.avro");
		DatumWriter<User> userDatumWriter = new SpecificDatumWriter<User>(
				User.class);
		DataFileWriter<User> fileWriter = new DataFileWriter<User>(
				userDatumWriter);
		fileWriter.create(u.getSchema(), f);
		fileWriter.append(u);
		fileWriter.close();
		
		DatumReader<User> datumReader = new SpecificDatumReader<User>(User.class);
		DataFileReader<User> fileReader = new DataFileReader<User>(f, datumReader);
		while(fileReader.hasNext()) {
			u = fileReader.next();
			System.out.println(u.getName() + " # " + u.getFavoriteNumber());
		}
		fileReader.close();
	}

}
