package model;

//import com.sun.xml.internal.txw2.output.XmlSerializer;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.IOException;
import static java.lang.System.in;

public class RepositoryClass
{
    public static  TrackList scanForTrack(String path) throws IOException  {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        byte[] buffer = new byte[128];
        char[] str = new char[128];
        ArrayList<Track> trackList = new ArrayList<Track>();
        for (int i = 0; i < listOfFiles.length; i++)
        {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith(".mp3"))
            {
                RandomAccessFile mp3file = new RandomAccessFile(listOfFiles[i], "rw");
                mp3file.seek(mp3file.length()-128);
                mp3file.read(buffer);
                for (int j = 0; j < buffer.length; j++)
                    str[j] = (char) buffer[j];
                String nameOfTrack = "";
                String album = "";
                String band = "";
                for (int j = 3; j < 33; j++)
                    nameOfTrack += str[j];
                for (int j = 33; j<63; j++)
                    band += str[j];
                for (int j = 63; j<93; j++)
                    album += str[j];
                Track newTrack = new Track(nameOfTrack ,album, band, "", "");
                trackList.add(i, newTrack);
            }
        }
        TrackList tracks=new TrackList(trackList);
        return tracks;
    }
    public static void WriterXmlTrackList(TrackList tracList, String str) throws FileNotFoundException{
         

         FileOutputStream out = new FileOutputStream(str+".xml"); 
          XMLEncoder xml = new XMLEncoder(out);
          xml.writeObject(tracList.getTracks().size());
          for(int i=0;i<tracList.getTracks().size();i++)
          xml.writeObject(tracList.getTrack(i).getName()+";"+tracList.getTrack(i).getAlbum()+";"+tracList.getTrack(i).getBand()+";"+tracList.getTrack(i).getDuration()+";"+tracList.getTrack(i).getGenre()+";");
       
          xml.close();
        }
    
    public static TrackList ReadXmlTrackList(String str) throws FileNotFoundException, IOException{
      

          FileInputStream in=new FileInputStream(str+".xml");
         // BufferedInputStream buf=new BufferedInputStream(in);
          XMLDecoder xml = new XMLDecoder(in);
          TrackList trackList=new TrackList();
          String tracks;
          int index=0;
          int size=(int) xml.readObject();
//          trackList=(TrackList) xml.readObject();
          while(index<size){
               tracks=(String) xml.readObject();
               String [] tr;
               tr=tracks.split(";");
               String [] masStr=new String[5];
               for(int i=0;i<tr.length;i++){
               masStr[i]=tr[i];}
               Track track=new Track(masStr[0],masStr[1],masStr[2],masStr[3],masStr[4]);
               trackList.addTrack(index, track);
               index++;}
        
           xml.close();
          return trackList;
          
        
    }
    public static void WriterXmlTrack(Track track, String str) throws FileNotFoundException{
         FileOutputStream out = new FileOutputStream(str+".xml"); 
         XMLEncoder xml = new XMLEncoder(out);
         xml.writeObject(track.getName()+";"+track.getAlbum()+";"+track.getBand()+";"+track.getDuration()+";"+track.getGenre()+";");
         xml.close();
        }
}
