import java.util.*;

class Solution {

    int n, k;
    int[][] tree;
    int[] prod;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.n = nums.length;
        this.k = k;

        // tree[node][r] = number of non-empty prefixes
        // having product % k == r
        tree = new int[4 * n][k];

        // prod[node] = product of whole segment % k
        prod = new int[4 * n];

        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            update(1, 0, n - 1, index, value % k);

            // Get segment [start, n-1]
            Node res = query(1, 0, n - 1, start, n - 1);

            ans[q] = res.count[x];

        }

        return ans;
    }

    // ---------------------------------------------------
    // Build
    // ---------------------------------------------------

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {

            int rem = nums[l] % k;

            prod[node] = rem;

            tree[node][rem] = 1;

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        merge(node, node * 2, node * 2 + 1);
    }

    // ---------------------------------------------------
    // Merge two segments
    // ---------------------------------------------------

    void merge(int node, int left, int right) {

        Arrays.fill(tree[node], 0);

        int leftProd = prod[left];

        // Prefixes entirely inside left
        for (int rem = 0; rem < k; rem++) {

            tree[node][rem] += tree[left][rem];
        }

        // Prefixes which contain the whole left
        // segment and then some prefix of right
        for (int rem = 0; rem < k; rem++) {

            int newRem = (int) ((long) leftProd * rem % k);

            tree[node][newRem] += tree[right][rem];
        }

        prod[node] =
                (int) ((long) prod[left] * prod[right] % k);
    }

    // ---------------------------------------------------
    // Update
    // ---------------------------------------------------

    void update(int node, int l, int r,
                int index, int value) {

        if (l == r) {

            Arrays.fill(tree[node], 0);

            prod[node] = value;

            tree[node][value] = 1;

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        merge(node, node * 2, node * 2 + 1);
    }

    // ---------------------------------------------------
    // Query
    // ---------------------------------------------------

    Node query(int node, int l, int r,
               int ql, int qr) {

        if (ql <= l && r <= qr) {

            Node res = new Node(k);

            res.prod = prod[node];

            for (int rem = 0; rem < k; rem++) {
                res.count[rem] = tree[node][rem];
            }

            return res;
        }

        int mid = (l + r) / 2;

        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        Node left =
                query(node * 2, l, mid, ql, qr);

        Node right =
                query(node * 2 + 1, mid + 1, r, ql, qr);

        return mergeNodes(left, right);
    }

    // ---------------------------------------------------
    // Merge query results
    // ---------------------------------------------------

    Node mergeNodes(Node left, Node right) {

        Node res = new Node(k);

        // Prefixes entirely in left
        for (int rem = 0; rem < k; rem++) {

            res.count[rem] += left.count[rem];
        }

        // Prefixes extending into right
        for (int rem = 0; rem < k; rem++) {

            int newRem =
                    (int) ((long) left.prod * rem % k);

            res.count[newRem] += right.count[rem];
        }

        res.prod =
                (int) ((long) left.prod * right.prod % k);

        return res;
    }

    // ---------------------------------------------------
    // Node
    // ---------------------------------------------------

    static class Node {

        int prod;
        int[] count;

        Node(int k) {
            count = new int[k];
        }
    }
}