public class TestURL {
	public static void main(String[] args) throws Exception{
		URL url = new URL("");
		
		InputStream is = url.openStream();
		byte[] b = new byte[20];
		
		int len;
		while((len=is.read(b))!=-1){
			String str = new String(b,0,len);
			System.out.println(str);
		}
		
		is.close();
		
		//需要向服务端写入
		URLConnection urlConnection = url.openConnection();
		InputStream is1 = urlConnection.getInputStream();
		FileOutputStream fos = new FileOutputStream(new File("down.txt"));
		byte[] b1 = new byte[1024];
		int len1;
		while((len1=is1.read(b1))!=-1){
			fos.write(b1, 0, len1);
		}
		
		fos.close();
		is1.close();
	}
}
