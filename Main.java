import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

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

			Stack<String> stack = new Stack<>();
			ArrayList<String> links = new ArrayList();
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
					String tag = tagName.toString();
					tagRecord = false;
					stack.push(tag);
					if(tag.charAt(1)=='a'){
						System.out.print("<-"+Integer.toString(links.size()+1)+"->[");
						int linkIndex = tag.indexOf("href=");
						if(linkIndex!=-1){
							linkIndex+=5;
							char endPoint = tag.charAt(linkIndex);
							int endPointIndex = tag.substring(linkIndex+1).indexOf(endPoint)+linkIndex+1;
							String linkAddress = tag.substring(linkIndex+1,endPointIndex);
							links.add(linkAddress);
						}
					}
					if(tag.substring(0,3).contains("/a")){
						System.out.print("] ");
					}

					if(tag.substring(0,4).contains("img")){
						System.out.print("<-"+Integer.toString(links.size()+1)+"->[IMAGE] ");
						int linkIndex = tag.indexOf("src=");
						if(linkIndex!=-1){
							linkIndex+=4;
							char endPoint = tag.charAt(linkIndex);
							int endPointIndex = tag.substring(linkIndex+1).indexOf(endPoint)+linkIndex+1;
							String linkAddress = tag.substring(linkIndex+1,endPointIndex);
							links.add(linkAddress);
						}
					}
					if(stack.peek()==tagName.substring(1)){

					}
					tagName.delete(0, tagName.length());				
				}
            }
            filereader.close();
			System.out.print("\n<<< eof >>>\n");
			Scanner scan = new Scanner(System.in);
			while(true){
				System.out.print("enter number: ");
				int command = Integer.parseInt(String.valueOf(scan.next()));
				switch(command){
					case 0:break;
					case 1:break;
					case 2:break;
					case 3:break;
					default:continue;
				}
			}
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }
    }
}