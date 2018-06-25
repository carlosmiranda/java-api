/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.zold.api;

/**
 * Wallet.
 *
 * @author Yegor Bugayenko (yegor256@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Wallet {
    /**
     * 64-bit unsigned integer.
     * @return 
     */
    long id();

    /**
     * Make a payment.
     * @param amt amount to pay
     * @param bnf wallet ID of beneficiary
     * @return the transaction
     */
    Transaction pay(Amount amt, char bnf);

    /**
     * Merge both {@code this} and {@code other}. Fails if they are not the
     * same wallet, as identified by their {@link #id() id}.
     * @param other other wallet
     * @return the merged wallet
     */
    Wallet merge(Wallet other);

    /**
     * This wallet's ledger.
     * @return this wallet's ledger
     */
    Iterable<Transaction> ledger();
}
