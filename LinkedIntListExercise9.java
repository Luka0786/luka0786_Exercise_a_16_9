package Kap16Exercise9;

import java.util.NoSuchElementException;

public class LinkedIntListExercise9
{
    // Simple first version of LinkedIntListExercise5 with just a constructor
// and methods for add and toString.
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntListExercise9()
    {
        front = null;
    }

    // post: returns comma-separated, bracketed version of list
    public String toString()
    {
        if (front == null)
        {
            return "[]";
        } else
        {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null)
            {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post: appends the given value to the end of the list
    public void add(int value)
    {
        if (front == null)
        {
            front = new ListNode(value);
        } else
        {
            ListNode current = front;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    private ListNode nodeAt(int index)
    {
        ListNode current = front;
        for (int i = 0; i < index; i++)
        {
            current = current.next;
        }
        return current;
    }

    public int size()
    {
        int count = 0;
        ListNode current = front;
        while (current != null)
        {
            current = current.next;
            count++;
        }
        return count;
    }

    public void remove(int index)
    {
        if (index == 0)
        {
            front = front.next;
        } else
        {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // Metoden til opgave 1
    public void set(int index, int value)
    {
        ListNode current = nodeAt(index);
        current.data = value;
    }


    // Metoden til opgave 2
    public int max(LinkedIntListExercise9 list)
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        } else
        {
            int max = front.data;
            ListNode current = front.next;

            while (current != null)
            {
                if (current.data > max)
                {
                    max = current.data;
                }
                current = current.next;
            }
            return max;
        }
    }

    //Metode til opgave 3
    public boolean isSorted()
    {
        boolean tempBoolean = false;
        ListNode current = front;
        ListNode temp = current.next;

        while (current != null)
        {
            if (temp.data > current.data)
            {
                tempBoolean = true;
            }
            current = temp;
            if (current.next != null)
            {
                temp = current.next;
            }
        }
        return tempBoolean;
    }

    //Metode til opgave 4
    public int lastIndexOf(int valueOfIndex)
    {
        int index = 0;
        ListNode current = front;

        while (current != null)
        {
            if (current.data == valueOfIndex)
            {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }


    //Metode til opgave 7
    public int deleteBack()
    {
        if (front == null)
        {
            throw new NoSuchElementException();
        }

        int temp;

        ListNode current = front;

        // Kigger to gange foran current for at se om det er enden, hvilket er null
        while (current.next.next != null)
        {
            current = current.next;
        }
        temp = current.next.data;
        current.next = null;
        return temp;
    }

    //Metode til opgave 8
    public void switchPairs()
    {
        //If... new node
    }

    //Metode til opgave 9
    public LinkedIntListExercise9 stutter()
    {
        int value = 0;
        LinkedIntListExercise9 theList = new LinkedIntListExercise9();
        ListNode current = front;

        while (current != null)
        {
            int tempValue;

            tempValue = current.data;
            value = current.data;

            theList.add(tempValue);
            theList.add(value);

            current = current.next;
        }

        return theList;
    }
}


