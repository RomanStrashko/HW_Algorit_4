import org.w3c.dom.Node;


public class HashMap {
    Node head;
    Node[] massiv = new Node[16];


    public int size(){
        int size = 0;
        for (Integer i = 0; i < massiv.length; i++) {
            int index = i.hashCode()%16;
            if (massiv[index] != null){
                Node tempNode = massiv[index];
                while (tempNode != null){
                    size++;
                    tempNode = tempNode.next;
                }
            }

        }
        return size;
    }

    public boolean containsKey(Integer key){
        boolean k = false;
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    k = true;
                    return k;
                }
                tempNode = tempNode.next;
            }
        } return k;
    }

    public boolean containsValue(Integer value){
        boolean v = false;
        for (Integer i = 0; i < massiv.length; i++) {
            int index = i.hashCode()%16;
            if (massiv[index] != null){
                Node tempNode = massiv[index];
                while (tempNode != null){
                    if (tempNode.value == value){
                        v = true;
                        return v;
                    }
                    tempNode = tempNode.next;
                }
            }

        }
        return v;
    }

    public Object replays(Integer key, Integer v){
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    Integer x = tempNode.value;
                    tempNode.value = v;
                    return x;
                }
                tempNode = tempNode.next;
            }
        } return null;
    }

    public Object get(Integer key){
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            while (tempNode != null) {
                if (tempNode.key == key) {
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
        } return null;
    }

    public Object remove(Integer key){
        int index = key.hashCode()%16;
        if (massiv[index] != null) {
            Node tempNode = massiv[index];
            if (tempNode.key == key && tempNode.next == null){
                massiv[index] = null;
                return tempNode.value;
            }
            if (tempNode.key == key && tempNode.next != null){
                massiv[index] = tempNode.next;
                return tempNode.value;
            }
            while (tempNode.next != null){
                if (tempNode.next.key == key){
                    Integer tmp = tempNode.next.value;
                    tempNode.next = tempNode.next.next;
                    return tmp;
                }
                tempNode = tempNode.next;
            }
        }
        return null;
    }

    public Object put(int v, int k){
        Node temp = new Node();
        temp.value = v;
        temp.key = k;
        temp.hash = temp.key.hashCode()%16;
        if (massiv[temp.hash] != null){
            Node tempNode = massiv[temp.hash];
            while (tempNode != null){
                if (tempNode.key == k){
                    return tempNode.value;
                }
                tempNode = tempNode.next;
            }
            temp.next = massiv[temp.hash];
        }massiv[temp.hash] = temp;
        return null;
    }
    class Node{
        Integer value, key;
        int hash;
        Node next;
    }

}

