class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if(lowerBound > upperBound)
                return nElems;
            else {
                if(a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }
    // Решение задачи вставки элемента в сортированный массив с помощью двоичного поиска
    //-----------------------------------------------------------
    public void insert(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;

            if (lowerBound > upperBound)
                break;
            else {
                if(a[curIn] < value)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }

        for(int k = nElems; k > lowerBound; k--)
            a[k] = a[k - 1];

        a[lowerBound] = value;
        nElems++;
    }
    //-----------------------------------------------------------

    public boolean delete(long value) {
        int j = find(value);
        if(j == nElems)
            return false;
        else {
            for(int k = j; k < nElems; k++)
                a[k] = a[k + 1];
            nElems--;
            return true;
        }
    }
    
    // Решение задачи результирующим массивом
    public static OrdArray merge(OrdArray one, OrdArray two) {
        OrdArray result;
        OrdArray second;

        if (one.size() >= two.size()) {
            result = one;
            second = two;
        } else {
            result = two;
            second = one;
        }

        for (int i = 0; i < second.size(); i++) {
            result.insert(second.a[i]);
        }

        return result;
    }

    public void display() {
        for(int j = 0; j < nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
}

class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray arr;
        OrdArray arr1;
        OrdArray arr2;

        arr1 = new OrdArray(maxSize);
        arr2 = new OrdArray(maxSize);

        arr1.insert(11);
        arr1.insert(33);
        arr1.insert(66);
        arr1.insert(55);

        arr2.insert(22);
        arr2.insert(44);
        arr2.insert(77);
        arr2.insert(55);
        arr2.insert(68);

        arr2.delete(44);


        arr1.display();
        arr2.display();

        OrdArray.merge(arr1, arr2).display();
    }
}
