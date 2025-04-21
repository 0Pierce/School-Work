using System.Xml.Linq;

namespace LinkedListNodes
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Node Node1 = new Node() { DATA = 1 };
            Node Node2 = new Node() { DATA = 3 };
            Node Node3 = new Node() { DATA = 3 };

            tempFirstNode.NEXT = Node1;
            tempLastNode.NEXT = Node3;

        }
    }
}