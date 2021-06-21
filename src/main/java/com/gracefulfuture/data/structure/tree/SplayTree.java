package com.gracefulfuture.data.structure.tree;

/**
* @description      伸展树
* @author           chenkun
* @create           2021/6/17 10:11
* @version          1.0
*/
public class SplayTree<T extends Comparable<T>> {

    private SplayTreeNode<T> mRoot;    // 根结点

    public class SplayTreeNode<T extends Comparable<T>> {
        T key;                // 关键字(键值)
        SplayTreeNode<T> left;    // 左孩子
        SplayTreeNode<T> right;    // 右孩子

        public SplayTreeNode() {
            this.left = null;
            this.right = null;
        }

        public SplayTreeNode(T key, SplayTreeNode<T> left, SplayTreeNode<T> right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    public SplayTree() {
        mRoot=null;
    }

    /*
     * 前序遍历"伸展树"
     */
    private void preOrder(SplayTreeNode<T> tree) {
        if(tree != null) {
            System.out.print(tree.key+" ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    /**
    * @description  先序遍历伸展树
    * @author       chenkun
    * @date         2021/6/17 11:00
    * @return		void
    */
    public void preOrder() {
        preOrder(mRoot);
    }

    /*
     * 中序遍历"伸展树"
     */
    private void inOrder(SplayTreeNode<T> tree) {
        if(tree != null) {
            inOrder(tree.left);
            System.out.print(tree.key+" ");
            inOrder(tree.right);
        }
    }

    /**
    * @description  中序遍历伸展树
    * @author       chenkun
    * @date         2021/6/17 11:00
    * @return		void
    */
    public void inOrder() {
        inOrder(mRoot);
    }


    /*
     * 后序遍历"伸展树"
     */
    private void postOrder(SplayTreeNode<T> tree) {
        if(tree != null)
        {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.print(tree.key+" ");
        }
    }

    /**
    * @description  后序遍历伸展树
    * @author       chenkun
    * @date         2021/6/17 10:59
    * @return		void
    */
    public void postOrder() {
        postOrder(mRoot);
    }


    /*
     * (递归实现)查找"伸展树tree"中键值为key的节点
     */
    private SplayTreeNode<T> search(SplayTreeNode<T> tree, T key) {
        if (tree==null) {
            return tree;
        }

        int cmp = key.compareTo(tree.key);
        if (cmp < 0) {
            return search(tree.left, key);
        } else if (cmp > 0) {
            return search(tree.right, key);
        } else {
            return tree;
        }
    }

    public SplayTreeNode<T> search(T key) {
        return search(mRoot, key);
    }

    /*
     * (非递归实现)查找"伸展树tree"中键值为key的节点
     */
    private SplayTreeNode<T> iterativeSearch(SplayTreeNode<T> tree, T key) {
        while (tree != null) {
            int cmp = key.compareTo(tree.key);

            if (cmp < 0) {
                tree = tree.left;
            } else if (cmp > 0) {
                tree = tree.right;
            } else {
                return tree;
            }
        }

        return tree;
    }

    public SplayTreeNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    /*
     * 查找最小结点：返回tree为根结点的伸展树的最小结点。
     */
    private SplayTreeNode<T> minimum(SplayTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }

        while(tree.left != null) {
            tree = tree.left;
        }
        return tree;
    }

    /**
    * @description  获取最小节点的值
    * @author       chenkun
    * @date         2021/6/17 10:56
    * @return		T
    */
    public T minimum() {
        SplayTreeNode<T> p = minimum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    /*
     * 查找最大结点：返回tree为根结点的伸展树的最大结点。
     */
    private SplayTreeNode<T> maximum(SplayTreeNode<T> tree) {
        if (tree == null) {
            return null;
        }

        while(tree.right != null) {
            tree = tree.right;
        }
        return tree;
    }

    /**
    * @description  获取最大节点的值
    * @author       chenkun
    * @date         2021/6/17 10:54
    * @return		T
    */
    public T maximum() {
        SplayTreeNode<T> p = maximum(mRoot);
        if (p != null) {
            return p.key;
        }

        return null;
    }

    /*
     * 旋转key对应的节点为根节点，并返回根节点。
     *
     * 注意：
     *   (a)：伸展树中存在"键值为key的节点"。
     *          将"键值为key的节点"旋转为根节点。
     *   (b)：伸展树中不存在"键值为key的节点"，并且key < tree.key。
     *      b-1 "键值为key的节点"的前驱节点存在的话，将"键值为key的节点"的前驱节点旋转为根节点。
     *      b-2 "键值为key的节点"的前驱节点存在的话，则意味着，key比树中任何键值都小，那么此时，将最小节点旋转为根节点。
     *   (c)：伸展树中不存在"键值为key的节点"，并且key > tree.key。
     *      c-1 "键值为key的节点"的后继节点存在的话，将"键值为key的节点"的后继节点旋转为根节点。
     *      c-2 "键值为key的节点"的后继节点不存在的话，则意味着，key比树中任何键值都大，那么此时，将最大节点旋转为根节点。
     */
    private SplayTreeNode<T> splay(SplayTreeNode<T> tree, T key) {
        if (tree == null) {
            return tree;
        }

        SplayTreeNode<T> N = new SplayTreeNode<T>();
        SplayTreeNode<T> left = N;
        SplayTreeNode<T> right = N;
        SplayTreeNode<T> c;

        for (;;) {

            int cmp = key.compareTo(tree.key);
            if (cmp < 0) {

                if (tree.left == null) {
                    break;
                }

                if (key.compareTo(tree.left.key) < 0) {
                    c = tree.left;                           /* rotate right */
                    tree.left = c.right;
                    c.right = tree;
                    tree = c;
                    if (tree.left == null) {
                        break;
                    }
                }
                right.left = tree;                               /* link right */
                right = tree;
                tree = tree.left;
            } else if (cmp > 0) {

                if (tree.right == null) {
                    break;
                }

                if (key.compareTo(tree.right.key) > 0) {
                    c = tree.right;                          /* rotate left */
                    tree.right = c.left;
                    c.left = tree;
                    tree = c;
                    if (tree.right == null) {
                        break;
                    }
                }

                left.right = tree;                              /* link left */
                left = tree;
                tree = tree.right;
            } else {
                break;
            }
        }

        left.right = tree.left;                                /* assemble */
        right.left = tree.right;
        tree.left = N.right;
        tree.right = N.left;

        return tree;
    }

    public void splay(T key) {
        mRoot = splay(mRoot, key);
    }

    /*
     * 将结点插入到伸展树中，并返回根节点
     *
     * 参数说明：
     *     root 伸展树的根节点
     *     insertion 被插入的结点
     */
    private SplayTreeNode<T> insert(SplayTreeNode<T> root, SplayTreeNode<T> insertion) {
        int cmp;
        //找到的目标位置节点
        SplayTreeNode<T> destination = null;
        //被比较节点
        SplayTreeNode<T> comparison = root;

        // 查找insertion的插入位置
        while (comparison != null) {
            destination = comparison;
            cmp = insertion.key.compareTo(comparison.key);
            if (cmp < 0)
                comparison = comparison.left;
            else if (cmp > 0)
                comparison = comparison.right;
            else {
                System.out.printf("不允许插入相同节点(%d)!\n", insertion.key);
                insertion = null;
                return root;
            }
        }
        //伸展树开始没有节点
        if (destination == null)
            root = insertion;
        else {
            cmp = insertion.key.compareTo(destination.key);
            if (cmp < 0)
                destination.left = insertion;
            else
                destination.right = insertion;
        }

        return root;
    }

    /**
    * @description  插入键值为key的节点
    * @author       chenkun
    * @param		key
    * @date         2021/6/17 11:02
    * @return		void
    */
    public void insert(T key) {
        SplayTreeNode<T> insertion = new SplayTreeNode<T>(key,null,null);

        // 如果新建结点失败，则返回。
        if (insertion == null) {
            return;
        }

        // 插入节点
        mRoot = insert(mRoot, insertion);
        // 将节点(key)旋转为根节点
        mRoot = splay(mRoot, key);
    }

    /*
     * 删除键值key对应的结点，并返回被删除的结点
     *
     * 参数说明：
     *     tree 伸展树的根节点
     *     key 删除的结点
     */
    private SplayTreeNode<T> remove(SplayTreeNode<T> tree, T key) {
        SplayTreeNode<T> x;

        if (tree == null){
            return null;
        }

        // 查找键值为key的节点，找不到的话直接返回。
        if (search(tree, key) == null){
            return tree;
        }

        // 将key对应的节点旋转为根节点。
        tree = splay(tree, key);

        if (tree.left != null) {
            // 将"tree的前驱节点"旋转为根节点
            x = splay(tree.left, key);
            // 移除tree节点
            x.right = tree.right;
        } else {
            x = tree.right;
        }

        tree = null;

        return x;
    }

    /**
    * @description  删除键值为key的节点
    * @author       chenkun
    * @param		key
    * @date         2021/6/17 11:24
    * @return		void
    */
    public void remove(T key) {
        mRoot = remove(mRoot, key);
    }

    /*
     * 销毁伸展树
     */
    private void destroy(SplayTreeNode<T> tree) {
        if (tree == null){
            return;
        }
        //销毁左子树
        if (tree.left != null){
            destroy(tree.left);
        }
        //销毁右子树
        if (tree.right != null){
            destroy(tree.right);
        }

        tree = null;
    }

    public void clear() {
        destroy(mRoot);
        mRoot = null;
    }

    /*
     * 打印"伸展树"
     *
     * key        -- 节点的键值
     * direction  --  0，表示该节点是根节点;
     *               -1，表示该节点是它的父结点的左孩子;
     *                1，表示该节点是它的父结点的右孩子。
     */
    private void print(SplayTreeNode<T> tree, T key, int direction) {

        if(tree != null) {
            if(direction==0){// tree是根节点
                System.out.printf("%2d is root\n", tree.key);
            }else{// tree是分支节点
                System.out.printf("%2d is %2d's %6s child\n", tree.key, key, direction==1?"right" : "left");
            }
            //打印左子树
            print(tree.left, tree.key, -1);
            //打印右子树
            print(tree.right,tree.key,  1);
        }
    }

    public void print() {
        if (mRoot != null){
            print(mRoot, mRoot.key, 0);
        }
    }
}
