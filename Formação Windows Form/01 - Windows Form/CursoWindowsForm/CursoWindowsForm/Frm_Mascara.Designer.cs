namespace CursoWindowsForm
{
    partial class Frm_Mascara
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.Mtxt_Data = new System.Windows.Forms.MaskedTextBox();
            this.Lbl_Data = new System.Windows.Forms.Label();
            this.Dtp_Data = new System.Windows.Forms.DateTimePicker();
            this.button1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Mtxt_Data
            // 
            this.Mtxt_Data.Location = new System.Drawing.Point(22, 49);
            this.Mtxt_Data.Mask = "00/00/0000";
            this.Mtxt_Data.Name = "Mtxt_Data";
            this.Mtxt_Data.Size = new System.Drawing.Size(200, 22);
            this.Mtxt_Data.TabIndex = 0;
            this.Mtxt_Data.ValidatingType = typeof(System.DateTime);
            // 
            // Lbl_Data
            // 
            this.Lbl_Data.AutoSize = true;
            this.Lbl_Data.Location = new System.Drawing.Point(22, 26);
            this.Lbl_Data.Name = "Lbl_Data";
            this.Lbl_Data.Size = new System.Drawing.Size(101, 17);
            this.Lbl_Data.TabIndex = 1;
            this.Lbl_Data.Text = "Informe a Data";
            // 
            // Dtp_Data
            // 
            this.Dtp_Data.Format = System.Windows.Forms.DateTimePickerFormat.Short;
            this.Dtp_Data.Location = new System.Drawing.Point(22, 83);
            this.Dtp_Data.Name = "Dtp_Data";
            this.Dtp_Data.Size = new System.Drawing.Size(200, 22);
            this.Dtp_Data.TabIndex = 2;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(22, 120);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(200, 28);
            this.button1.TabIndex = 3;
            this.button1.Text = "Converter";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.Btn_Converter_Click);
            // 
            // Frm_Mascara
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(251, 176);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.Dtp_Data);
            this.Controls.Add(this.Lbl_Data);
            this.Controls.Add(this.Mtxt_Data);
            this.Name = "Frm_Mascara";
            this.Text = "Frm_Mascara";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MaskedTextBox Mtxt_Data;
        private System.Windows.Forms.Label Lbl_Data;
        private System.Windows.Forms.DateTimePicker Dtp_Data;
        private System.Windows.Forms.Button button1;
    }
}