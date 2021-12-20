package lintcode.colleciton.selected.phase5_stack_and_queue;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class RemoveParentheses_2506 {
    /**
     * @param s: A string with lowercase letters and parentheses
     * @return: A string which has been removed invalid parentheses
     */
    //Key Idea: similar to 423, 263; in addition, using an extra Set to record the unmatched parentheses position
    public static String removeParentheses(String s) {
        // write your code here
        if (s.isEmpty()) return s;
        Stack<Integer> stack = new Stack<>();
        Set<Integer> rmvSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                stack.push(i);
            } else if (cur == ')') {
                if (stack.size() == 0 || s.charAt(stack.peek()) != '(') {
                    rmvSet.add(i);
                    continue;
                }
                stack.pop();
            }
        }

        //add the remaining '('s position into the set
        while (stack.size() != 0) {
            rmvSet.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (rmvSet.contains(i)) continue;
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "pns(i(bhbi)kj()kojs(tzanmj)rxmsl(zkl(i(ggqqeyo)bxht((auwsuuyhzb)cq((jabbcui))cpe(jj))(snd(a(mpe(ooe)ggjp))((k)iudv)acfk(kl(vagyd)c)r)))(y)i)k)))b)))q)(s))kxoy()kg)zbpyk)(ish()yc)ljjc()((qm(hec(zb((d)qvl(stob)y)s)rj)(f)zyf()(uw)dwjuryn)r()qegnfef()hm()nos(zb((suu))eudvoei)(p)ebmqqv)fooe)uiqs)t(ggcuh(uc))(dc)r)jpc(w)icgr)jjkhz(i(hh(sxjhxlqbl)cd(((x(syah)pc)wb(mtksjq(rg(abg(a(absm)crryc())f)ecejbrizgel((v)(qz())fox)x)()v(it()k(rabrs)e(urx))gg)q)p(rpjv)kfqjnz(ivn)lurl)fu))mam)v()pthlcse(((nd)uw)tqozric(kan)p)e)(k)u(s)h(f(neiundsufv()vw(ih)()md))u))ex((jib))eqixg())dpooo((d()s)sw(we)fzvus()wuzs(h()j))n)ykcbaxew(f()r))bcxa))y((vs)mqfn((utlr(mcw((oc)b)r(fvhtaxzxc(djuq)))))(((edik)g(ikygpv(ncpuueplg(((po(sjeweb()txbqafuh)t)))bpat()x((j()((())(lz(vbx))rsr(((jn(((jc)l((tlqkq(xwtbpy)plol)njbxmdh(e(fw(aaetrpcp)ecw()y(p(cfepipj)d(m((xf(((n(o(hoy(fhe(pc(wb)(r)ka(hwir)hl(pw)j)vndjiw(uowqzi)lz()l)y)(jwp)))boqy)npj(h)hnpxki)f(fjxsyb)ojmr)((rk(ux())jrzezn)usy)(zdozd(by)p(z))lvkb()e)z))kw)gcyficicdws)lt(";
        System.out.println(removeParentheses(input));
    }
}
