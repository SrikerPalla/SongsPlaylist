package com.sriker;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("SVSC");
        album.addSong("sirimalle vaakitlo", 5.0);
        album.addSong("Aaraduguluntada", 6.0);
        album.addSong("Vaana Chinukulu", 7.0);
        albums.add(album);

        album = new Album("Raja");
        album.addSong("Edo oka ragam", 5.25);
        album.addSong("Palavinchu oka raagam", 6.25);
        album.addSong("Kavvinchake", 5.30);
        albums.add(album);

        LinkedList<Song> myPlayList = new LinkedList<Song>();

        albums.get(0).addToPlayList("sirimalle vaakitlo", myPlayList);
        albums.get(1).addToPlayList("Edo oka ragam", myPlayList);
        albums.get(1).addToPlayList("Palavinchu oka raagam", myPlayList);
        albums.get(1).addToPlayList(24, myPlayList);
        albums.get(1).addToPlayList("jalsa jalsa", myPlayList);

        play(myPlayList);
    }

    private static void play(LinkedList<Song> myPlayList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = myPlayList.listIterator();
        if(myPlayList.size() == 0){
            System.out.println("The playlist has no songs ");
            return;
        }else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("playlist is completed");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    }else{
                        System.out.println(" we have reached the end of the playlist ");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    }else{
                        System.out.println(" You have reached the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        }
                        else{
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else{
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            forward = true;
                        }
                        else{
                            System.out.println("we reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(myPlayList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(myPlayList.size()>0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                        }
                        else if(listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }

    private static void printList(LinkedList<Song> myPlayList){
        // As we are not going backwards and forward we are not going to use the ListIterator
        // we are just using the regular Iterator
        // Iterator has no capability to go backward
        Iterator<Song> iterator = myPlayList.iterator();
        System.out.println(" ************************************ ");
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(" ********************************** ");
    }


}
