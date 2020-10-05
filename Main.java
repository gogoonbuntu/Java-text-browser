import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

class Main {
  	public static void main(String[] args) {
		readFile();
  	}

	public static void readFile(){
        try{
            //파일 객체 생성
            File file = new File("s.html");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            
			int singleCh = 0;
			StringBuilder tagName = new StringBuilder(); 
			StringBuilder contents = new StringBuilder();
			boolean tagRecord = false;

			Stack<String> stack = new Stack();

            while((singleCh = filereader.read()) != -1){
                
				if(singleCh=='<'){
					tagRecord = true;
				}
				if(tagRecord){
					tagName.append((char)singleCh);
				} else {
					System.out.print((char)singleCh);
				}
				if(singleCh=='>'){
					tagRecord = false;
					System.out.println(tagName.toString());
				}
            }
            filereader.close();

        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }
}