package bwt;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Encoder comprimir = new Encoder();
		Decoder descomprimir = new Decoder();
		File archivo = new File ("../texto.txt");
		FileReader fr = new FileReader (archivo);
		BufferedReader br = new BufferedReader(fr);
		String linea = br.readLine();
		String texto=linea;
		while((linea=br.readLine())!=null)
			texto+=linea;
        texto=texto.replace(' ','_');
        texto+='$';
        String a=comprimir.encode(texto);
        System.out.println("Comprimido :  "+a);
        String b=descomprimir.decode(a);
        fr.close();
        b=b.replace('_',' ').replace('.','\n');
        FileWriter w = new FileWriter("../comprimido.txt");
        BufferedWriter bw = new BufferedWriter(w);
        PrintWriter wr = new PrintWriter(bw); 
        wr.write(a);
        wr.close();
        bw.close();
        System.out.println("Descomp:  "+b);
        FileWriter w1 = new FileWriter("../descomprimido.txt");
        BufferedWriter bw1 = new BufferedWriter(w1);
        PrintWriter wr1 = new PrintWriter(bw1); 
        wr1.write(b);
        wr1.close();
        bw1.close();
	}

}
