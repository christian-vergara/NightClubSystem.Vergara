package Model.Bags;

import Model.Objects.Table;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Studio on 12/12/2016.
 */
public class TableBag {

    private static TableBag tableBag = new TableBag();

    private static List<Table> tableList = new List<Table>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @Override
        public Iterator<Table> iterator() {
            return null;
        }

        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {
            return null;
        }

        @Override
        public boolean add(Table table) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends Table> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, Collection<? extends Table> c) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public Table get(int index) {
            return null;
        }

        @Override
        public Table set(int index, Table element) {
            return null;
        }

        @Override
        public void add(int index, Table element) {

        }

        @Override
        public Table remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @Override
        public ListIterator<Table> listIterator() {
            return null;
        }

        @Override
        public ListIterator<Table> listIterator(int index) {
            return null;
        }

        @Override
        public List<Table> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    public void addTable(Table table) {
        tableList.add(table);
    }

    public void removeTable(Table table) {
        tableList.remove(table);
    }

    public static TableBag getTableBag(){
        return tableBag;
    }

    public Table findTable(int tblNumber) {
        for(int i = 0;i < tableList.size();i++){
            if (tableList.get(i).getTblNbr() == tblNumber) {
                return tableList.get(i);
            }
        }
        return null;
    }

    public List<Table> getTableList() {
        return tableList;
    }
}
