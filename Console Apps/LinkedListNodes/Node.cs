using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedListNodes
{
    internal class Node
    {
        private int Data;
        private Node Next = null;

        public int DATA { set; get; }
        public Node NEXT { set; get; }

        public Node() { }
        public Node(int _data, Node _next)
        {
            this.Data = _data;
            this.Next = _next;
        }
    }
}
