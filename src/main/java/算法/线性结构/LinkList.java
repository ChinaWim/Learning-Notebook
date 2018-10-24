package 算法.线性结构;

import java.util.Iterator;
import java.util.stream.Stream;

/**
 * @author m969130721@163.com
 * @date 18-5-31 下午6:57
 */
public class LinkList implements Iterable {
    public LinkList next;
    public Object data;
    public int length = 0;


    public Object get(int index) {
        LinkList linkListNext = this.next;
        if (linkListNext == null) {
            return null;
        }
        while (index-- > 0) {
            linkListNext = linkListNext.next;
            if (linkListNext == null) {
                return null;
            }
        }
        return linkListNext.data;
    }

    public boolean remove(int index) {
        if (length - 1 < index || index < 0) {
            return false;
        }
        length--;
        LinkList nextLinkList = this.next;
        if (index == 0) {
            this.next = nextLinkList.next;
            return true;
        }
        LinkList preLinkList = null;
        while (index-- > 0) {
            if (index == 0) {
                preLinkList = nextLinkList;
            }
            nextLinkList = nextLinkList.next;
        }
        //nextLinkList == removeNode
        preLinkList.next = nextLinkList.next;
        return true;
    }


    public void add(Object value) {
        this.length++;

        LinkList newLinkList = new LinkList();
        newLinkList.data = value;

        LinkList linkListNext = this.next;

        if (linkListNext == null) {
            this.next = newLinkList;
            return;
        }

        while (linkListNext != null) {
            LinkList element = linkListNext.next;
            if (element == null) {
                linkListNext.next = newLinkList;
                return;
            }
            linkListNext = linkListNext.next;
        }
    }

    public boolean add(int index, Object value) {
        if (this.length < index || index < 0) {
            return false;
        }
        this.length++;
        LinkList newLinkList = new LinkList();
        newLinkList.data = value;

        LinkList nextLinkList = this.next;
        if (index == 0) {
            newLinkList.next = nextLinkList;
            this.next = newLinkList;
            return true;
        }
        LinkList preLinkList = null;
        while (index-- > 0 && nextLinkList != null) {
            if (index == 0) {
                preLinkList = nextLinkList;
            }
            nextLinkList = nextLinkList.next;
        }
        if (nextLinkList == null) {
            preLinkList.next = newLinkList;
            return true;
        }
        newLinkList.next = preLinkList.next;
        preLinkList.next = newLinkList;
        return true;
    }


    public boolean replace(int index, Object value) {
        if (this.length - 1 < index || index < 0) {
            return false;
        }

        LinkList nextLinkList = this.next;

        while (index-- > 0) {
            nextLinkList = nextLinkList.next;
        }
        nextLinkList.data = value;
        return true;
    }


    public long size() {
        int size = 0;
        LinkList linkListNext = this.next;
        while (linkListNext != null) {
            size++;
            linkListNext = linkListNext.next;
        }
        return size;
    }


    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(0, 1);
        linkList.add(1, 2);
        linkList.add(2, 3);
        linkList.add(3, 4);
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        System.out.println(linkList.get(0));
        System.out.println(linkList.replace(linkList.length - 1, 1100));
//        System.out.println(linkList.remove(0));
        Iterator iterator = linkList.iterator();
        System.out.println("---------------------------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Override
    public String toString() {
        return "LinkList{" +
                "next=" + next +
                ", data=" + data +
                ", length=" + length +
                '}';
    }

    @Override
    public Iterator iterator() {
        LinkList linkList = this.next;
        Iterator iterator = new Iterator() {

            LinkList element = linkList;

            @Override
            public boolean hasNext() {
                return element != null;
            }

            @Override
            public Object next() {
                Object data = element.data;
                element = element.next;
                return data;
            }
        };
        return iterator;
    }
}

