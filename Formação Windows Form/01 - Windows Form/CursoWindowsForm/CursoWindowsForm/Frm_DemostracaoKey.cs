using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CursoWindowsForm
{
    public partial class Frm_DemostracaoKey : Form
    {
        public Frm_DemostracaoKey()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void Txt_Input_Leave(object sender, EventArgs e)
        {
            Lbl_Minusculo.Text = Txt_Input.Text.ToLower();
            Lbl_Maiusculo.Text = Txt_Input.Text.ToUpper();
        }

        private void Btn_Fechar_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void Btn_Reset_Click(object sender, EventArgs e)
        {
            Txt_Minusculo.Text = "";
            Txt_Maiusculo.Text = "";
            Txt_Input.Text = "";
            Txt_Msg.Text = "";
        }

        private void Txt_Input_KeyDown(object sender, KeyEventArgs e)
        {
            Txt_Msg.AppendText("\r\n" + "Pressionei a tecla " + e.KeyCode + "\r\n");
            Txt_Msg.AppendText("\t" + "Código da tecla " + ((int) e.KeyCode) + "\r\n");
            Txt_Msg.AppendText("\t" + "Nome tecla " + e.KeyData + "\r\n");
            Txt_Minusculo.Text = e.KeyCode.ToString().ToLower();
            Txt_Maiusculo.Text = e.KeyCode.ToString().ToUpper();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
