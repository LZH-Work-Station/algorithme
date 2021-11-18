package leetcode;

import model.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> deque = new LinkedList<>();
        // 必须要添加第一个额外的头 因为如果 被删除的就是第一个 没有办法找到这个链表的头了，如果删除第一个 让前面这个额外的头指向第二个
        // 然后取额外头的下一个就行了
        ListNode res = new ListNode(0, head);
        deque.addFirst(res);
        while(head!=null){
            deque.addFirst(head);
            head = head.next;
        }
        int i = 0;
        ListNode prev = null;
        ListNode next = null;
        while(i!=n+1){
            prev = deque.removeFirst();
            i++;
        }
        prev.next = prev.next.next;
        return res.next;

    }
}
