abcde
fghtk
  
rmnll

String content = null;
        File file = new File("File.txt");
        FileReader reader = null;
        try{
            reader = new FileReader(file);
            char[] s = new char[(int) file.length()];
            reader.read(s);
            content = new String(s);
            reader.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }