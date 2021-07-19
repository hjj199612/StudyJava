package src.analyseFile;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JG0115_9Month {
    public static void main(String[] args){
        //ArrayList<String> arrayList = new ArrayList<>();
        int count=0;
        HashMap<String,Integer> hashMap=new HashMap<>(200);
        try {
            FileReader fr = new FileReader("C:\\Users\\huangjj24\\Downloads\\JG0109美的9月完整内容1.txt");
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                count++;
                String[] report=str.split("\\|");
                if(report.length<5) continue;
                int x=0;
                if(hashMap.get(report[4])!=null) {
                    x=hashMap.get(report[4]);
                }
                hashMap.put(report[4],(Integer.valueOf(++x)));
        //        arrayList.add(str);
            }
            bf.close();
            fr.close();


            List<List> excel = new ArrayList<>();
            for(String key:hashMap.keySet())
            {
                List<Object> itm=new ArrayList<>(2);
                itm.add(key);
                itm.add(hashMap.get(key));
                excel.add(itm);
            }
            String path="C:\\Users\\huangjj24\\Desktop\\11.txt";
            writeFileContext(excel,path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeFileContext(List<List>  strings, String path) throws Exception {
        File file = new File(path);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (List<Object> l : strings) {
            writer.write(l.get(0) + "|"+l.get(1)+"\n");
        }
        writer.close();
    }
}
