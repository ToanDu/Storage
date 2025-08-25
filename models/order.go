package models

import (
	"context"
	"errors"

	"github.com/google/uuid"
	"github.com/jackc/pgx/v5/pgxpool"
)

type Order struct {
	ID        uuid.UUID
	TxnRef    string
	Amount    int64
	OrderInfo string
	Status    string
	TxnDate   string // <-- this is your vnp_CreateDate (yyyyMMddHHmmss)
}

func CreateOrder(db *pgxpool.Pool, txnRef string, amount int64, info string, txnDate string) error {
	_, err := db.Exec(context.Background(),
		`INSERT INTO orders (id, txn_ref, amount, order_info, status, txn_date)
         VALUES ($1, $2, $3, $4, 'pending', $5)`,
		uuid.New(), txnRef, amount, info, txnDate)
	return err
}

func UpdateOrderStatus(db *pgxpool.Pool, txnRef, status string) error {
	ct, err := db.Exec(context.Background(),
		"UPDATE orders SET status=$1 WHERE txn_ref=$2", status, txnRef)
	if err != nil {
		return err
	}
	if ct.RowsAffected() == 0 {
		return errors.New("no rows updated")
	}
	return nil
}

func GetOrderByTxnRef(db *pgxpool.Pool, txnRef string) (*Order, error) {
	row := db.QueryRow(context.Background(),
		`SELECT id, txn_ref, amount, order_info, status, txn_date
         FROM orders WHERE txn_ref=$1 LIMIT 1`, txnRef)
	var o Order
	if err := row.Scan(&o.ID, &o.TxnRef, &o.Amount, &o.OrderInfo, &o.Status, &o.TxnDate); err != nil {
		return nil, err
	}
	return &o, nil
}
