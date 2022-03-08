
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

    public class HashTable<TKey, TValue> implements Iterable<TKey>
    {
        @Override
        public Iterator<TKey> iterator() {
            return null;
        }

        private static class Node<TKey, TValue>
        {
            public TKey key;
            public TValue value;
            public Node<TKey, TValue> next;

            @Override
            public String toString()
            {
                return String.format(
                        "{%s, %s}",
                        key,
                        value);
            }
        }

        private final Node<TKey, TValue>[] buckets;
        private int size;

        public HashTable()
        {
            buckets = (Node<TKey, TValue>[])new Node[128];
        }

        public HashTable(int size)
        {
            buckets = (Node<TKey, TValue>[])new Node[size];
        }


        public int size()
        {
            return size;
        }

        private int hashIndex(TKey key)
        {

            return (key.hashCode() & 0x7fffffff) % buckets.length;
        }

        public void put(TKey key, TValue value)
        {
            Node<TKey, TValue> newNode = new Node<>();
            newNode.key = key;
            newNode.value = value;

            int hashIndex = hashIndex(key);

            if (buckets[hashIndex] == null)
            {
                buckets[hashIndex] = newNode;
                size++;
            }
            else
            {
                Node<TKey, TValue> current = buckets[hashIndex];


                while (current.next != null
                        && current.key.hashCode() != key.hashCode()
                        && !current.key.equals(key))
                {
                    current = current.next;
                }

                if (current.key.equals(key))
                {
                    current.value = value;
                }


                else
                {
                    current.next = newNode;
                    size++;
                }
            }
        }


        public TValue get(TKey key)
        {
            int hashIndex = hashIndex(key);
            Node<TKey, TValue> current = buckets[hashIndex];

            if (current == null)
            {
                throw new NoSuchElementException(
                        String.format(
                                "%s{%s}",
                                getClass().getName(),
                                key)
                );
            }


            while (current.next != null
                    && !(current.key.hashCode() == key.hashCode()
                    && current.key.equals(key)))
            {
                current = current.next;
            }


            if (current.key.equals(key))
            {
                return current.value;
            }

            throw new NoSuchElementException(
                    String.format(
                            "%s{%s}",
                            getClass().getName(),
                            key)
            );
        }

        public boolean contains(TKey key)
        {
            int hashIndex = hashIndex(key);
            Node<TKey, TValue> current = buckets[hashIndex];

            if (current == null)
            {
                return false;
            }


            while (current.next != null
                    && current.key.hashCode() != key.hashCode()
                    && !current.key.equals(key))
            {
                current = current.next;
            }

            return current.key.equals(key);
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();

            sb.append('[');

            for (TKey key : this)
            {
                sb
                        .append(
                                String.format(
                                        "{%s, %s}",
                                        key,
                                        get(key))
                        ).append(", ");
            }

            sb.replace(sb.length() - 2, sb.length(), "");

            sb.append(']');
            return sb.toString();
        }


        // test method
        public static void main(String[] args)
        {

            HashTable<String, Integer> ht =
                    new HashTable<>();

            Scanner in = new Scanner(System.in);
            System.out.print("Number of inputs: ");

            int amount = in.nextInt();

            in.nextLine();

            System.out.println("Inputs:");
            for (int count = 0; count < amount; count++)
            {
                String line = in.nextLine();
                String[] values = line.split("\\s+");

                int integer = Integer.parseInt(values[1]);
                String str = values[0];

                ht.put(str, integer);
            }

            System.out.println(ht);
        }
    }

